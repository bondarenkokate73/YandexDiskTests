package tests.uiTests;

import helpers.Waiters;
import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static helpers.WorkWithDriver.goToPage;
import static pagesAndElements.FilesPage.FILES_PAGE_URL;

public class ContextMenuTest extends UiBaseTest {

    @BeforeMethod
    public void goToWorkFolder() {
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (!staticElementsForPage.isListEqualsElement(filesOnPage, workFolder)) {
            staticElementsForPage
                    .clickButtonCreate()
                    .clickButtonCreateFolder()
                    .inputNameFolder(workFolder)
                    .clickButtonSaveFolder();
        }
        workElement = findStaticElements.getElementOfName(workFolder);
        workElement.click();
        Assert.assertTrue(contextMenuElements.isElementSelected(workElement),
                "Элемент не был выделен.");
    }

    @Description("Uc23 - Поделиться элементом")
    @Test(priority = 0)
    public void shareElementTest() {
        SoftAssert softAssert = new SoftAssert();
        contextMenuElements.clickButtonShare();
        softAssert.assertTrue(
                contextMenuElements.isContextMenuVisible(),
                "Контекстное меню с ссылкой не появилось.");
        String publishLink = contextMenuElements.getPublishLink();
        goToPage(publishLink, getDriver());
        softAssert.assertTrue(
                contextMenuElements.isPublicLink(publishLink),
                "По этой ссылке нет опубликованного файла.");
        softAssert.assertAll();
    }

    @Description("Uc24 - Скачать элемент")
    @Test(priority = 1)
    public void downloadElementTest() {
        contextMenuElements.clickButtonDownload();
        File file = new File(workDirectory + "/" + workFolder + ".zip");
        Waiters.waitUntilFileDownload(file);
        Assert.assertTrue(file.exists(), "Скачанного файла не существует.");
    }

    @Description("Uc25 - Переименовать элемент")
    @Test(priority = 2)
    public void renameElementTest() {
        final String newNameFolder = "RenameUiTestFolder";
        contextMenuElements.clickButtonRename();
        staticElementsForPage.inputNameFolder(newNameFolder)
                .clickButtonSaveFolder();
        filesOnPage = staticElementsForPage.getFilesOnPage(newNameFolder);
        Assert.assertTrue(
                staticElementsForPage.isListEqualsElement(
                        filesOnPage, newNameFolder),
                "Папки с новым именем на странице найдено не было.");
    }

    @Description("Uc26 - Переместить элемент")
    @Test(priority = 3)
    public void transferElementTest() throws InterruptedException {
        String folder = "Загрузки";
        SoftAssert softAssert = new SoftAssert();
        contextMenuElements.clickButtonTransfer()
                .selectTransferFolder(folder)
                .clickButtonTransferInModalWindowElement();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertFalse(
                staticElementsForPage.isListEqualsElement(
                        filesOnPage,
                        "Папка осталась на прежнем месте."));
        goToPage(getDriver(), FILES_PAGE_URL + "/" + folder);
        Thread.sleep(3000);
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(
                staticElementsForPage.isListEqualsElement(
                        filesOnPage,
                        workFolder),
                "Перемещенной папки не существует.");

    }

    @Description("Uc27 - Копировать элемент в то же место")
    @Test(priority = 4)
    public void copyElementToThisPlaceTest() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        SoftAssert softAssert = new SoftAssert();
        contextMenuElements.clickButtonCopy()
                .clickButtonCopyElement()
                .clickButtonContinueElement();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(
                staticElementsForPage.isListEqualsElement(
                        filesOnPage,
                        workFolder),
                "Скопированной папки не существует.");
        softAssert.assertTrue(
                staticElementsForPage.isListEqualsElement(
                        filesOnPage,
                        workFolder + "_" + simpleDateFormat.format(date)),
                "Продублированной папки не существует.");
    }

    @Description("Uc28 - Удалить элемент")
    @Test(priority = 5)
    private void deleteElementTest() {
        contextMenuElements.clickButtonDelete();
        List<WebElement> filesOnPage = findStaticElements.getFilesOnPage();
        Assert.assertTrue(
                staticElementsForPage.isElementDelete(
                        filesOnPage,
                        workFolder),
                "Папка не была удалена.");
    }

    @AfterMethod
    public void deleteResources() {
        Boolean flag = true;
        do {
            filesOnPage = staticElementsForPage.getFilesOnPage();
            if (staticElementsForPage.isListContainsElement(filesOnPage, workFolder)) {
                workElement = findStaticElements.getElementContainsName(workFolder);
                workElement.click();
                contextMenuElements.clickButtonDelete();
            } else {
                flag = false;
            }
        } while (flag);
        goToPage(getDriver(), FILES_PAGE_URL + "/" + "Загрузки");
        do {
            try {
                filesOnPage = staticElementsForPage.getFilesOnPage();
                if (staticElementsForPage.isListContainsElement(filesOnPage, workFolder)) {
                    workElement = findStaticElements.getElementContainsName(workFolder);
                    workElement.click();
                    contextMenuElements.clickButtonDelete();
                } else {
                    flag = true;
                }
            } catch (Exception ex) {
            }
        } while (!flag);
    }
}

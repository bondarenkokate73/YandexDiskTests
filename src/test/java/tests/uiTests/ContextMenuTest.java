package tests.uiTests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesAndElements.ContextMenuElements;
import pagesAndElements.FilesPage;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static helpers.WorkWithDriver.goToPage;

public class ContextMenuTest extends UiBaseTest {

    private final String workDirectory = "C:/Users/Kate/Downloads";
    private final String workFolder = "TestFolder";
    private WebElement workElement;
    private ContextMenuElements contextMenuElements;
    private List<String> filesOnPage;

    @BeforeMethod
    public void goToWorkFolder() {
        contextMenuElements = new ContextMenuElements(getDriver());
        goToPage(getDriver(), FilesPage.FILES_PAGE_URL + workFolder);
        if (!getDriver().getCurrentUrl().contains(workFolder)) {
            filesPage.createWorkFolder(workFolder);
            goToPage(getDriver(), FilesPage.FILES_PAGE_URL + workFolder);
        }
        goToPage(getDriver(), "");
        workElement = findStaticElements.getElementOfName(workFolder);
    }

    @Description("Uc23 - Поделиться элементом")
    @Test
    public void shareElementTest() {
        SoftAssert softAssert = new SoftAssert();
        workElement.click();
        contextMenuElements.clickButtonShare();
        softAssert.assertTrue(
                contextMenuElements.isContextMenuVisible(),
                "Контекстное меню с ссылкой не появилось.");
        String publishLink = contextMenuElements.getPublishLink();
        goToPage(getDriver(), publishLink);
        softAssert.assertFalse(
                contextMenuElements.isErrorMessageVisible(publishLink),
                "По этой ссылке нет опубликованного файла.");
        softAssert.assertAll();
    }

    @Description("Uc24 - Скачать элемент")
    @Test
    public void downloadElementTest() {
        workElement.click();
        contextMenuElements.clickButtonDownload();
        File file = new File(workDirectory + workFolder + ".zip");
        Assert.assertTrue(file.exists(), "Скачанного файла не существует.");
    }

    @Description("Uc25 - Переименовать элемент")
    @Test
    public void renameElementTest() {
        final String newNameFolder = "RenameTestFolder";
        workElement.click();
        contextMenuElements.clickButtonRename();
        staticElementsForPage.inputNameFolder(newNameFolder)
                .clickButtonSaveFolder();
        filesOnPage = staticElementsForPage.getFilesOnPage(newNameFolder);
        Assert.assertTrue(
                staticElementsForPage.isListContainsElement(
                        filesOnPage, newNameFolder),
                "Папки с новым именем на странице найдено не было.");
    }

    @AfterTest
    public void renameWorkFolder() {
        workElement.click();
        contextMenuElements.clickButtonRename();
        staticElementsForPage.inputNameFolder(workFolder)
                .clickButtonSaveFolder();
    }

    @Description("Uc26 - Переместить элемент")
    @Test
    public void transferElementTest() {
        SoftAssert softAssert = new SoftAssert();
        workElement.click();
        contextMenuElements.clickButtonTransfer()
                .selectTransferFolder()
                .clickButtonTransferElement();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertFalse(
                staticElementsForPage.isListContainsElement(
                        filesOnPage,
                        "Папка осталась на прежнем месте."));
        goToPage(getDriver(), "disk/Загрузки");
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(
                staticElementsForPage.isListContainsElement(
                        filesOnPage,
                        workFolder),
                "Перемещенной папки не существует.");

    }

    @Description("Uc27 - Копировать элемент в то же место")
    @Test
    public void copyElementToThisPlaceTest() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yyyy");
        SoftAssert softAssert = new SoftAssert();
        workElement.click();
        contextMenuElements.clickButtonCopy()
                .clickButtonCopyElement()
                .clickButtonContinueElement();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(
                staticElementsForPage.isListContainsElement(
                        filesOnPage,
                        workFolder),
                "Скопированной папки не существует.");
        softAssert.assertTrue(
                staticElementsForPage.isListContainsElement(
                        filesOnPage,
                        workFolder + "_" + simpleDateFormat.format(date)),
                "Продублированной папки не существует.");
    }

    @Description("Uc28 - Удалить элемент")
    @Test
    private void deleteElementTest() {
        workElement.click();
        contextMenuElements.clickButtonDelete();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        Assert.assertTrue(
                staticElementsForPage.isListContainsElement(
                        filesOnPage,
                        workFolder),
                "Папка не была удалена.");
    }
}

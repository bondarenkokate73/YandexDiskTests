package tests.uiTests.UploadFileTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.uiTests.UiBaseTest;

import java.io.File;

public class UploadFileTest extends UiBaseTest {

    @BeforeMethod
    public void before() {
        file = new File(path + nameFile);
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (staticElementsForPage
                .isListEqualsElement(filesOnPage, nameFile)) {
            workElement = findStaticElements.getElementOfName(nameFile);
            if (workElement != null) {
                workElement.click();
                contextMenuElements.clickButtonDelete();
            }
        }
    }

    @Description("Uc14 - Загрузка файлов")
    @Test
    public void downloadFileOnDiskTest() {
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(file.exists(), "Файла не существует.");
        staticElementsForPage.downloadFileOnDisk(file);
        Assert.assertTrue(staticElementsForPage
                        .isModalWindowDownloadFileDisplayed(),
                "Модальное окно загрузки файлов не появилось.");
        downloadFiles = staticElementsForPage.getNamesOfDownloadFiles();
        softAssert.assertTrue(staticElementsForPage
                        .isListEqualsElement(downloadFiles, nameFile),
                "Список загруженных файлов не содержит искомого элемента.");
        staticElementsForPage.closeModalWindowDownloadFiles();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(staticElementsForPage
                        .isListEqualsElement(filesOnPage, nameFile),
                "Список файлов на странице не содержит загруженный элемент.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteFile() {
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (staticElementsForPage
                .isListEqualsElement(filesOnPage, nameFile)) {
            workElement = findStaticElements.getElementOfName(nameFile);
            if (workElement != null) {
                workElement.click();
                contextMenuElements.clickButtonDelete();
            }
        }
    }
}

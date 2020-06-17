package tests.uiTests.UploadFileTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.uiTests.UiBaseTest;

import java.io.File;

public class UploadExistsFileTest extends UiBaseTest {

    @BeforeMethod
    public void before() {
        file = new File(path + nameFile);
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (!staticElementsForPage
                .isListEqualsElement(filesOnPage, nameFile)) {
            staticElementsForPage.downloadFileOnDisk(file);
        }
    }

    @Description("Uc15 - Загрузка уже существующего файла")
    @Test
    public void downloadOnDiskExistingFileTest() {
        Assert.assertTrue(file.exists(), "Файла не существует.");
        staticElementsForPage.downloadFileOnDisk(file);
        Assert.assertTrue(staticElementsForPage
                        .isModalWindowDownloadFileDisplayed(),
                "Модальное окно загрузки файлов не появилось.");
        Assert.assertTrue(staticElementsForPage.isFileIsDouble(),
                "Загружаемый файл не был дублем.");
        staticElementsForPage.closeModalWindowDownloadFiles();
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

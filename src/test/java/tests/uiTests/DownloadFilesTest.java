package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.util.List;

public class DownloadFilesTest extends UiBaseTest {

    private List<String> downloadFiles;
    private List<String> filesOnPage;
    private final String path = "C:/";
    private final String nameFile = "Lancer.jpg";
    private File file;

    @BeforeMethod
    public void before() {
        file = new File(path + nameFile);
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
                        .isListContainsElement(downloadFiles, nameFile),
                "Список загруженных файлов не содержит искомого элемента.");
        staticElementsForPage.closeModalWindowDownloadFiles();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(staticElementsForPage
                        .isListContainsElement(filesOnPage, nameFile),
                "Список файлов на странице не содержит загруженный элемент.");
        softAssert.assertAll();
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

    @Description("Uc29 - Загрузка файла путем перетаскивания в окно браузера")
    @Test
    public void downloadFileDragAndDrop() {
        Assert.assertTrue(file.exists(), "Файла не существует.");
        staticElementsForPage.downloadFileDragAndDrop(file.getAbsolutePath());
        Assert.assertTrue(staticElementsForPage
                        .isModalWindowDownloadFileDisplayed(),
                "Модальное окно загрузки файлов не появилось.");
        filesOnPage = staticElementsForPage.getFilesOnPage();
        Assert.assertTrue(staticElementsForPage
                        .isListContainsElement(filesOnPage, nameFile),
                "Список файлов на странице не содержит загруженный элемент.");
    }
}

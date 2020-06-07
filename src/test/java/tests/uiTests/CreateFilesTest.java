package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pagesAndElements.FilesPage;

import java.util.List;

import static helpers.WorkWithDriver.*;

public class CreateFilesTest extends UiBaseTest {

    private final String workFolder = "TestFolder";
    private List<String> filesOnPage;
    private String defaultNameTextDoc = "Документ.docx";
    private String defaultNameTable = "Таблица.xlsx";
    private String defaultNamePresentation = "Презентация.pptx";
    private String defaultNameAlbum = "Новый альбом";
    private String oldTab;

    @BeforeMethod
    public void goToWorkFolder() {
        goToPage(getDriver(), FilesPage.FILES_PAGE_URL + workFolder);
        if (!getDriver().getCurrentUrl().contains(workFolder)) {
            filesPage.createWorkFolder(workFolder);
            goToPage(getDriver(), FilesPage.FILES_PAGE_URL + workFolder);
        }
    }

    @Description("Uc17 - Создание Текстового документа")
    @Test
    public void createTextDoc() {
        oldTab = saveOldTab(getDriver());
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreateTextDoc();
        goToOldTab(getDriver(), oldTab);
        filesOnPage = staticElementsForPage.getFilesOnPage(defaultNameTextDoc);
        Assert.assertTrue(staticElementsForPage
                        .isListContainsElement(filesOnPage, defaultNameTextDoc),
                "Созданного текстового документа найдено не было.");
    }

    @Description("Uc18 - Создание Таблицы")
    @Test
    public void createTable() {
        oldTab = saveOldTab(getDriver());
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreateTable();
        goToOldTab(getDriver(), oldTab);
        filesOnPage = staticElementsForPage.getFilesOnPage(defaultNameTable);
        Assert.assertTrue(staticElementsForPage
                        .isListContainsElement(filesOnPage, defaultNameTable),
                "Созданной таблицы найдено не было.");
    }

    @Description("Uc19 - Создание Презентации")
    @Test
    public void createPresentation() {
        oldTab = saveOldTab(getDriver());
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreatePresentation();
        goToOldTab(getDriver(), oldTab);
        filesOnPage = staticElementsForPage.getFilesOnPage(defaultNamePresentation);
        Assert.assertTrue(staticElementsForPage
                        .isListContainsElement(filesOnPage, defaultNamePresentation),
                "Созданной презентации найдено не было.");
    }

    @Description("Uc20 - Создание Альбома")
    @Test
    public void createAlbum() {
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreateAlbum()
                .clickButtonContinueCreateAlbum()
                .clickCheckboxPhoto()
                .clickButtonCreateAlbumElement()
                .clickButtonPageAlbums();
        filesOnPage = staticElementsForPage.getFilesOnPage(defaultNameAlbum);
        Assert.assertTrue(staticElementsForPage
                        .isListContainsElement(filesOnPage, defaultNameAlbum),
                "Созданного альбома найдено не было.");
    }
}

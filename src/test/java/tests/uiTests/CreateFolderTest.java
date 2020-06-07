package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class CreateFolderTest extends UiBaseTest {

    private final String workFolder = "TestFolder";
    private List<String> filesOnPage;

    @Description("Uc16 - Создание папки")
    @Test
    public void createFolder() {
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreateFolder()
                .inputNameFolder(workFolder)
                .clickButtonSaveFolder();
        filesOnPage = staticElementsForPage.getFilesOnPage(workFolder);
        Assert.assertTrue(staticElementsForPage
                        .isListContainsElement(filesOnPage, workFolder),
                "Созданной папки найдено не было.");
    }
}

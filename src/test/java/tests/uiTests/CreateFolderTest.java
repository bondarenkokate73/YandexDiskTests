package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateFolderTest extends UiBaseTest {

    @BeforeMethod
    public void deleteFolderIfExists() {
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (staticElementsForPage.isListEqualsElement(filesOnPage, workFolder)) {
            workElement = findStaticElements.getElementOfName(workFolder);
            if (workElement != null) {
                workElement.click();
                contextMenuElements.clickButtonDelete();
            }
        }
    }

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
                        .isListEqualsElement(filesOnPage, workFolder),
                "Созданной папки найдено не было.");
    }

    @AfterMethod
    public void deleteFolder() {
        workElement = findStaticElements.getElementOfName(workFolder);
        if (workElement != null) {
            workElement.click();
            contextMenuElements.clickButtonDelete();
        }
    }
}

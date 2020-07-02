package tests.uiTests.CreateFilesTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.uiTests.UiBaseTest;

import static helpers.WorkWithDriver.closeThisTab;
import static helpers.WorkWithDriver.goToRightTab;

public class CreateTextDocTest extends UiBaseTest {

    private String defaultNameTextDoc = "Документ.docx";

    @BeforeMethod
    public void deleteFileIfExists() {
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (staticElementsForPage.isListEqualsElement(filesOnPage, defaultNameTextDoc)) {
            workElement = findStaticElements.getElementOfName(defaultNameTextDoc);
            if (workElement != null) {
                workElement.click();
                contextMenuElements.clickButtonDelete();
                staticElementsForPage.isElementDelete(
                        findStaticElements.getNamesFilesOnPage(),
                        defaultNameTextDoc);
            }
        }
    }

    @Description("Uc17 - Создание Текстового документа")
    @Test
    public void createTextDocTest() {
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreateTextDoc();
        goToRightTab(getDriver());
        closeThisTab(getDriver());
        filesOnPage = staticElementsForPage.getFilesOnPage(defaultNameTextDoc);
        Assert.assertTrue(staticElementsForPage
                        .isListEqualsElement(filesOnPage, defaultNameTextDoc),
                "Созданного текстового документа найдено не было.");
    }

    @AfterMethod
    public void deleteFile() throws InterruptedException {
        Thread.sleep(1000);
        workElement = findStaticElements.getElementOfName(defaultNameTextDoc);
        if (workElement != null) {
            workElement.click();
            contextMenuElements.clickButtonDelete();
        }
    }
}

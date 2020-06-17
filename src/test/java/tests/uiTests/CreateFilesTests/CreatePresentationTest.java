package tests.uiTests.CreateFilesTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.uiTests.UiBaseTest;

import static helpers.WorkWithDriver.closeThisTab;
import static helpers.WorkWithDriver.goToRightTab;

public class CreatePresentationTest extends UiBaseTest {

    private String defaultNamePresentation = "Презентация.pptx";

    @BeforeMethod
    public void deleteFileIfExists() {
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (staticElementsForPage.isListEqualsElement(filesOnPage, defaultNamePresentation)) {
            workElement = findStaticElements.getElementOfName(defaultNamePresentation);
            if (workElement != null) {
                workElement.click();
                contextMenuElements.clickButtonDelete();
                staticElementsForPage.isElementDelete(
                        findStaticElements.getNamesFilesOnPage(),
                        defaultNamePresentation);
            }
        }
    }

    @Description("Uc19 - Создание Презентации")
    @Test
    public void createPresentationTest() {
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreatePresentation();
        goToRightTab(getDriver());
        closeThisTab(getDriver());
        filesOnPage = staticElementsForPage.getFilesOnPage(defaultNamePresentation);
        Assert.assertTrue(staticElementsForPage
                        .isListEqualsElement(filesOnPage, defaultNamePresentation),
                "Созданной презентации найдено не было.");
    }

    @AfterMethod
    public void deleteFile() {
        workElement = findStaticElements.getElementOfName(defaultNamePresentation);
        if (workElement != null) {
            workElement.click();
            contextMenuElements.clickButtonDelete();
        }
    }
}

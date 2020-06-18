package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static helpers.WorkWithDriver.closeThisTab;
import static helpers.WorkWithDriver.goToRightTab;

public class TrashTest extends UiBaseTest {

    private String defaultNameTextDoc = "Документ.docx";

    @BeforeMethod
    public void addFileIntoTrash() {
        staticElementsForPage.clickButtonPageTrash();
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (filesOnPage.isEmpty()) {
            filesPage.goToPage();
            staticElementsForPage.clickButtonCreate();
            Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                    "Модальное окно создания не открылось.");
            staticElementsForPage
                    .clickButtonCreateTextDoc();
            goToRightTab(getDriver());
            closeThisTab(getDriver());
            findStaticElements.getElementOfName(defaultNameTextDoc).click();
            contextMenuElements.clickButtonDelete();
            staticElementsForPage.isElementDelete(
                    findStaticElements.getNamesFilesOnPage(),
                    defaultNameTextDoc);
        }
    }

    @Description("Uc30 - Очистка корзины")
    @Test
    private void deleteFilesFromTrash() throws InterruptedException {
        staticElementsForPage.clickButtonPageTrash()
                .clickButtonCleanTrash()
                .clickButtonApprovalCleanTrash();
        Assert.assertTrue(staticElementsForPage.isTrashClean(),
                "Не удалось дождаться опустения корзины.");
        Thread.sleep(1000);
        Assert.assertTrue(filesOnPage.isEmpty(),
                "Корзина не пуста.");
    }
}

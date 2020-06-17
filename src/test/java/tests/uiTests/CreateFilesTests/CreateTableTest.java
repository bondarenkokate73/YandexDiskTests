package tests.uiTests.CreateFilesTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.uiTests.UiBaseTest;

import static helpers.WorkWithDriver.closeThisTab;
import static helpers.WorkWithDriver.goToRightTab;

public class CreateTableTest extends UiBaseTest {

    private String defaultNameTable = "Таблица.xlsx";

    @BeforeMethod
    public void deleteFileIfExists() {
        filesOnPage = staticElementsForPage.getFilesOnPage();
        if (staticElementsForPage.isListEqualsElement(filesOnPage, defaultNameTable)) {
            workElement = findStaticElements.getElementOfName(defaultNameTable);
            if (workElement != null) {
                workElement.click();
                contextMenuElements.clickButtonDelete();
                staticElementsForPage.isElementDelete(
                        findStaticElements.getNamesFilesOnPage(),
                        defaultNameTable);
            }
        }
    }

    @Description("Uc18 - Создание Таблицы")
    @Test
    public void createTableTest() {
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        staticElementsForPage
                .clickButtonCreateTable();
        goToRightTab(getDriver());
        closeThisTab(getDriver());
        filesOnPage = staticElementsForPage.getFilesOnPage(defaultNameTable);
        Assert.assertTrue(staticElementsForPage
                        .isListEqualsElement(filesOnPage, defaultNameTable),
                "Созданной таблицы найдено не было.");
    }

    @AfterMethod
    public void deleteFile() {
        workElement = findStaticElements.getElementOfName(defaultNameTable);
        if (workElement != null) {
            workElement.click();
            contextMenuElements.clickButtonDelete();
        }
    }
}

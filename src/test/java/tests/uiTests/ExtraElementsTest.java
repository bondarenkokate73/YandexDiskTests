package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helpers.WorkWithDriver.closeThisTab;
import static helpers.WorkWithDriver.goToRightTab;

public class ExtraElementsTest extends UiBaseTest {
    @Description("Uc21 - Проверка элемента покупки дополнительного пространства")
    @Test
    public void checkButtonAddExtraSpaceTest() {
        staticElementsForPage.clickButtonAddSpace();
        goToRightTab(getDriver());
        Assert.assertTrue(staticElementsForPage
                        .isPageContainsUrl("tuning"),
                "Страница добавления места в диск не открылась.");
        closeThisTab(getDriver());
    }

    @Description("Uc22 - Проверка элемента «Установка приложения»")
    @Test
    public void checkButtonInstallAppTest() {
        staticElementsForPage.clickButtonDownloadApp();
        goToRightTab(getDriver());
        Assert.assertTrue(staticElementsForPage
                        .isPageContainsUrl("download"),
                "Страница скачивания приложения не открылась.");
        closeThisTab(getDriver());
    }
}

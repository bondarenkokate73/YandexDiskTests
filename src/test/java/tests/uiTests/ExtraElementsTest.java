package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtraElementsTest extends UiBaseTest {
    @Description("Uc21 - Проверка элемента покупки дополнительного пространства")
    @Test
    public void checkButtonAddExtraSpaceTest() {
        staticElementsForPage.clickButtonAddSpace();
        Assert.assertTrue(staticElementsForPage
                        .isPageContainsUrl("tuning"),
                "Страница добавления места в диск не открылась.");
    }

    @Description("Uc22 - Проверка элемента «Установка приложения»")
    @Test
    public void checkButtonInstallAppTest() {
        staticElementsForPage.clickButtonDownloadApp();
        Assert.assertTrue(staticElementsForPage
                        .isPageContainsUrl("download"),
                "Страница скачивания приложения не открылась.");
    }
}

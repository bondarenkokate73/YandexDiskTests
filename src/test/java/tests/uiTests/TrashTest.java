package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesAndElements.TrashPage;

import java.util.List;

public class TrashTest extends UiBaseTest {

    private TrashPage trashPage;
    private List<String> filesOnPage;

    @Description("Uc30 - Очистка корзины")
    @Test
    private void deleteFilesFromTrash() {
        trashPage = staticElementsForPage.clickButtonPageTrash();
        trashPage.clickButtonCleanTrash();
        filesOnPage = staticElementsForPage.getNamesOfDownloadFiles();
        Assert.assertTrue(filesOnPage.isEmpty(),
                "Корзина не пуста.");
    }
}

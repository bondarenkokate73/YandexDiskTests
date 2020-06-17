package tests.uiTests.CreateFilesTests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.uiTests.UiBaseTest;

public class CreateAlbumTest extends UiBaseTest {

    private String defaultNameAlbum = "Новый альбом";

    @BeforeMethod
    public void deleteFileIfExists() {
        staticElementsForPage.clickButtonPageAlbums();
        WebElement album = albumsPage.getAlbum();
        if (album != null) {
            album.click();
            albumsPage.clickButtonEtc()
                    .clickButtonDelete()
                    .clickButtonApprovedDelete();
        }
    }

    @Description("Uc20 - Создание Альбома")
    @Test
    public void createAlbum() {
        staticElementsForPage.clickButtonCreate();
        Assert.assertTrue(staticElementsForPage.isModalWindowCreateOpen(),
                "Модальное окно создания не открылось.");
        WebElement album = staticElementsForPage
                .clickButtonCreateAlbum()
                .clickButtonContinueCreateAlbum()
                .clickButtonCreateAlbumElement()
                .clickButtonPageAlbums()
                .getAlbum(defaultNameAlbum);
        Assert.assertTrue(album != null,
                "Созданного альбома найдено не было.");
    }

    @AfterMethod
    public void deleteFile() {
        staticElementsForPage.clickButtonPageAlbums();
        WebElement album = albumsPage.getAlbum();
        if (album != null) {
            album.click();
            albumsPage.clickButtonEtc()
                    .clickButtonDelete()
                    .clickButtonApprovedDelete();
        }
    }
}

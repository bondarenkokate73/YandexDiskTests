package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesAndElements.*;

public class NavigateToPagesTest extends UiBaseTest {

    @Description("Uc02 - Просмотр страницы «Последние»")
    @Test
    public void navigateLastPageTest() {
        LastPage lastPage = new LastPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPageLast();
        softAssert.assertEquals(lastPage.getHeader(),
                lastPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(lastPage.getUrl(),
                HOME_PAGE_URL + LastPage.LAST_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc03 - Просмотр страницы «Файлы»")
    @Test
    public void navigateFilesPageTest() {
        FilesPage filesPage = new FilesPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPageFiles();
        softAssert.assertEquals(filesPage.getHeader(),
                filesPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(filesPage.getUrl(),
                HOME_PAGE_URL + FilesPage.FILES_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc04 - Просмотр страницы «Фото»")
    @Test
    public void navigatePhotosPageTest() {
        PhotosPage photosPage = new PhotosPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPagePhotos();
        softAssert.assertEquals(photosPage.getHeader(),
                photosPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(photosPage.getUrl(),
                HOME_PAGE_URL + PhotosPage.PHOTOS_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc05 - Просмотр страницы «Альбомы»")
    @Test
    public void navigateAlbumsPageTest() {
        AlbumsPage albumsPage = new AlbumsPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPageAlbums();
        softAssert.assertEquals(albumsPage.getHeader(),
                albumsPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(albumsPage.getUrl(),
                HOME_PAGE_URL + AlbumsPage.ALBUMS_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc06 - Просмотр страницы «Общий доступ»")
    @Test
    public void navigatePublicAccessPageTest() {
        PublicAccessPage publicAccessPage = new PublicAccessPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPagePublicAccess();
        softAssert.assertEquals(publicAccessPage.getHeader(),
                publicAccessPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(publicAccessPage.getUrl(),
                HOME_PAGE_URL + PublicAccessPage.PUBLIC_ACCESS_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc07 - Просмотр страницы «История»")
    @Test
    public void navigateHistoryPageTest() {
        HistoryPage historyPage = new HistoryPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPageHistory();
        softAssert.assertEquals(historyPage.getHeader(),
                historyPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(historyPage.getUrl(),
                HOME_PAGE_URL + HistoryPage.HISTORY_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc08 - Просмотр страницы «Архив»")
    @Test
    public void navigateArchivePageTest() {
        ArchivePage archivePage = new ArchivePage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPageArchive();
        softAssert.assertEquals(archivePage.getHeader(),
                archivePage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(archivePage.getUrl(),
                HOME_PAGE_URL + ArchivePage.ARCHIVE_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc09 - Просмотр страницы «Корзина»")
    @Test
    public void navigateTrashPageTest() {
        TrashPage trashPage = new TrashPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPageTrash();
        softAssert.assertEquals(trashPage.getHeader(),
                trashPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertEquals(trashPage.getUrl(),
                HOME_PAGE_URL + TrashPage.TRASH_PAGE_URL,
                "Url нынешней страницы не соответствует нужному.");
        softAssert.assertAll();
    }

    @Description("Uc10 - Просмотр страницы «Загрузки»")
    @Test
    public void navigateDownloadPageTest() {
        DownloadPage downloadPage = new DownloadPage(getDriver());
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(filesPage.isFilesPage(),
                "Главная страница не открылась.");
        staticElementsForPage.clickButtonPageDownload();
        softAssert.assertEquals(downloadPage.getHeader(),
                downloadPage.PAGE_HEADER,
                "Страница не содержит нужного заголовка.");
        softAssert.assertAll();
    }
}

package pagesAndElements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class PhotosPage {

    private WebDriver driver;

    public static final String PHOTOS_PAGE_URL = "/photo";

    public StaticElementsForPage staticElementsForPage;

    public final String PAGE_HEADER = "Фото";

    public PhotosPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + PHOTOS_PAGE_URL);
        return new FilesPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public Boolean isPhotosPage() {
        return getUrl().contains(PHOTOS_PAGE_URL);
    }

    @Step("Получение заголовка на странице")
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }
}

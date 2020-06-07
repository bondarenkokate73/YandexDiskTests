package pagesAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class DownloadPage {
    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Page url.
     */
    public static final String DOWNLOAD_PAGE_URL = "/Загрузки";

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     *
     */
    public final String PAGE_HEADER = "Загрузки";

    /**
     * Page object constructor. Checks that page is open when created.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public DownloadPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Go to download page
     *
     * @return download page
     */
    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + DOWNLOAD_PAGE_URL);
        return new FilesPage(driver);
    }

    /**
     *
     */
    public String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     *
     */
    public Boolean isDownloadPage() {
        return getUrl().contains(DOWNLOAD_PAGE_URL);
    }

    /**
     *
     */
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }
}

package pagesAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class ArchivePage {

    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Page url.
     */
    public static final String ARCHIVE_PAGE_URL = "/attach";

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     *
     */
    public final String PAGE_HEADER = "Архив";

    /**
     * Page object constructor. Checks that page is open when created.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public ArchivePage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Go to archive page
     *
     * @return archive page
     */
    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + ARCHIVE_PAGE_URL);
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
    public Boolean isArchivePage() {
        return getUrl().contains(ARCHIVE_PAGE_URL);
    }

    /**
     *
     */
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }
}

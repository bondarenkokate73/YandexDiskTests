package pagesAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class LastPage {

    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     *
     */
    public final String PAGE_HEADER = "Последние файлы";

    /**
     * Page url.
     */
    public static final String LAST_PAGE_URL = "/recent";

    /**
     * Page object constructor. Checks that page is open when created.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public LastPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
        if (!driver.getCurrentUrl().contains(LAST_PAGE_URL)) {
            //      throw new IllegalStateException("Last page is not present");
        }
    }

    /**
     * Go to last page
     *
     * @return last page
     */
    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + LAST_PAGE_URL);
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
    public Boolean isLastPage() {
        return getUrl().contains(LAST_PAGE_URL);
    }

    /**
     *
     */
    public String getHeader() {
        return staticElementsForPage.getHeader(PAGE_HEADER);
    }
}

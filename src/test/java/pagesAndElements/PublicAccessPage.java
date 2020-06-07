package pagesAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class PublicAccessPage {
    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Page url.
     */
    public static final String PUBLIC_ACCESS_PAGE_URL = "/published";

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     *
     */
    public final String PAGE_HEADER = "Общий доступ";

    /**
     * Page object constructor. Checks that page is open when created.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public PublicAccessPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Go to public access page
     *
     * @return public access page
     */
    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + PUBLIC_ACCESS_PAGE_URL);
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
    public Boolean isPublicAccessPage() {
        return getUrl().contains(PUBLIC_ACCESS_PAGE_URL);
    }

    /**
     *
     */
    public String  getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }
}

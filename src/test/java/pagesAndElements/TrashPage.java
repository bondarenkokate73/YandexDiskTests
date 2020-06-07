package pagesAndElements;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class TrashPage {
    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Page url.
     */
    public static final String TRASH_PAGE_URL = "/trash";

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     *
     */
    public final String PAGE_HEADER = "Корзина";

    /**
     * Кнопка Очистить корзину.
     */
    @FindBy(css = "div.listing-head__additional-actions > button")
    private WebElement buttonCleanTrash;

    /**
     * Page object constructor. Checks that page is open when created.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public TrashPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Go to trash page
     *
     * @return trash page
     */
    public FilesPage goToPage() {
        Waiters.waitUntilUrlContainsText(TRASH_PAGE_URL, driver);
        driver.navigate().to(HOME_PAGE_URL + TRASH_PAGE_URL);
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
    public Boolean isTrashPage() {
        return getUrl().contains(TRASH_PAGE_URL);
    }

    /**
     *
     */
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }

    /**
     *
     */
    public void clickButtonCleanTrash() {
        buttonCleanTrash.click();
    }
}

package pagesAndElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     *
     */
    public final String PAGE_HEADER = "Результаты поиска";

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     * Page object constructor. Checks that page is open when created.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public SearchResultPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
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
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }
}

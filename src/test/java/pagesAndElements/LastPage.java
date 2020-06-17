package pagesAndElements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class LastPage {

    private WebDriver driver;

    public StaticElementsForPage staticElementsForPage;

    public final String PAGE_HEADER = "Последние файлы";

    public static final String LAST_PAGE_URL = "/recent";

    public LastPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
        if (!driver.getCurrentUrl().contains(LAST_PAGE_URL)) {
            //      throw new IllegalStateException("Last page is not present");
        }
    }

    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + LAST_PAGE_URL);
        return new FilesPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public Boolean isLastPage() {
        return getUrl().contains(LAST_PAGE_URL);
    }

    @Step("Получение заголовка на странице")
    public String getHeader() {
        return staticElementsForPage.getHeader(PAGE_HEADER);
    }
}

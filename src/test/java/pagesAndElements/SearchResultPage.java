package pagesAndElements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultPage {

    private WebDriver driver;

    public final String PAGE_HEADER = "Результаты поиска";

    public StaticElementsForPage staticElementsForPage;

    public SearchResultPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Получение заголовка на странице")
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }
}

package pagesAndElements;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class TrashPage {

    private WebDriver driver;

    public static final String TRASH_PAGE_URL = "/trash";

    public StaticElementsForPage staticElementsForPage;

    public final String PAGE_HEADER = "Корзина";

    /**
     * Кнопка Очистить корзину.
     */
    @FindBy(css = "div.listing-head__additional-actions > button")
    private WebElement buttonCleanTrash;

    @FindBy(css = "div.dialog__body > div > button")
    private List<WebElement> buttonApprovalCleanTrash;

    public TrashPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    public FilesPage goToPage() {
        Waiters.waitUntilUrlContainsText(TRASH_PAGE_URL, driver);
        driver.navigate().to(HOME_PAGE_URL + TRASH_PAGE_URL);
        return new FilesPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public Boolean isTrashPage() {
        return getUrl().contains(TRASH_PAGE_URL);
    }

    @Step("Получение заголовка на странице")
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }

    @Step("Очистка корзины")
    public TrashPage clickButtonCleanTrash() {
        Waiters.waitUntilElementToBeClickable(buttonCleanTrash, driver);
        buttonCleanTrash.click();
        return this;
    }

    @Step("Нажатие на кнопку подтверждения очистки корзины")
    public void clickButtonApprovalCleanTrash() {
        Waiters.waitUntilElementToBeClickable(
                buttonApprovalCleanTrash.get(1), driver);
        buttonApprovalCleanTrash.get(1).click();
    }
}

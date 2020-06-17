package pagesAndElements;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public final String HOME_PAGE_URL = "https://passport.yandex.ru/profile";

    public StaticElementsForPage staticElementsForPage;

    @FindBy(css = "input[id='passp-field-login']")
    private WebElement inputLoginElement;
    private By byInputLogin = By.cssSelector("input[id='passp-field-login']");

    @FindBy(css = "input[id='passp-field-passwd']")
    private WebElement inputPasswordElement;
    private By byInputPassword = By.cssSelector("input[id='passp-field-passwd']");

    @FindBy(css = "button[type='submit']")
    private WebElement buttonLogInElement;
    private By byButtonLogIn = By.cssSelector("button[type='submit']");

    @FindBy(css = "span[class='sts__service-name']")
    private WebElement loginPageElement;

    public LoginPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    public LoginPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }

    @Step("Ввод логина")
    public LoginPage sendLogin(final String login) {
        Waiters.waitUntilElementToBeClickable(
                inputLoginElement, driver);
        inputLoginElement.sendKeys(login);
        return this;
    }

    @Step("Ввод пароля")
    public LoginPage sendPassword(final String password) {
        Waiters.waitUntilElementToBeClickable(
                inputPasswordElement, driver);
        inputPasswordElement.sendKeys(password);
        return this;
    }

    @Step("Нажать на кнопку войти")
    public FilesPage pressButtonLogIn() {
        Waiters.waitUntilElementToBeClickable(
                buttonLogInElement, driver);
        buttonLogInElement.click();
        return new FilesPage(driver);
    }

    private String getUrl() {
        return driver.getCurrentUrl();
    }

    public Boolean isLoginPage() {
        Waiters.waitUntilUrlContainsText(HOME_PAGE_URL, driver);
        return getUrl().contains(HOME_PAGE_URL);
    }
}

package pagesAndElements;

import helpers.Waiters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /**
     * Browser driver.
     */
    private WebDriver driver;

    /**
     * Page url.
     */
    public final String HOME_PAGE_URL = "https://passport.yandex.ru/profile";

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     * Input login elements.
     */
    @FindBy(css = "input[id='passp-field-login']")
    private WebElement inputLoginElement;
    private By byInputLogin = By.cssSelector("input[id='passp-field-login']");

    /**
     * Input password elements.
     */
    @FindBy(css = "input[id='passp-field-passwd']")
    private WebElement inputPasswordElement;
    private By byInputPassword = By.cssSelector("input[id='passp-field-passwd']");

    /**
     * Button Log In elements.
     */
    @FindBy(css = "button[type='submit']")
    private WebElement buttonLogInElement;
    private By byButtonLogIn = By.cssSelector("button[type='submit']");

    @FindBy(css = "span[class='sts__service-name']")
    private WebElement loginPageElement;

    /**
     * Page object constructor. Checks that page is open when created.
     *
     * @param webDriver browser driver
     * @throws IllegalStateException if page is not open now
     */
    public LoginPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Go to last page
     *
     * @return last page
     */
    public LoginPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL);
        return this;
    }

    /**
     *
     */
    public LoginPage sendLogin(final String login) {
        Waiters.waitUntilElementToBeClickable(
                inputLoginElement, driver);
        inputLoginElement.sendKeys(login);
        return this;
    }

    /**
     *
     */
    public LoginPage sendPassword(final String password) {
        Waiters.waitUntilElementToBeClickable(
                inputPasswordElement, driver);
        inputPasswordElement.sendKeys(password);
        return this;
    }

    /**
     *
     */
    public FilesPage pressButtonLogIn() {
        Waiters.waitUntilElementToBeClickable(
                buttonLogInElement, driver);
        buttonLogInElement.click();
        return new FilesPage(driver);
    }

    /**
     *
     */
    private String getUrl() {
        return driver.getCurrentUrl();
    }

    /**
     *
     */
    public Boolean isLoginPage() {
        Waiters.waitUntilUrlContainsText(HOME_PAGE_URL, driver);
        return getUrl().contains(HOME_PAGE_URL);
    }
}

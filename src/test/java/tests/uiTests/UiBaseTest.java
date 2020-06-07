package tests.uiTests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pagesAndElements.FilesPage;
import pagesAndElements.FindStaticElements;
import pagesAndElements.LoginPage;
import pagesAndElements.StaticElementsForPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static helpers.ParametersProvider.getProperty;

/**
 * Base test for all ui tests
 */
public class UiBaseTest {

    /**
     * Драйвер.
     */
    private WebDriver driver;

    /**
     *
     */
    public StaticElementsForPage staticElementsForPage;

    /**
     *
     */
    public FindStaticElements findStaticElements;

    /**
     *
     */
    public LoginPage loginPage;

    /**
     *
     */
    public FilesPage filesPage;

    /**
     *
     */
    public final WebDriver getDriver() {
        return driver;
    }

    /**
     * Page url.
     */
    public static final String HOME_PAGE_URL = "https://disk.yandex.ru/client";

    /**
     * Создание драйвера.
     * Авторизация.
     */
    @Description("Uc01 - Авторизация в диске")
    @BeforeMethod
    public final void setEnvironment() throws IOException {
        System.setProperty("webdriver.chrome.bin", "/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        staticElementsForPage = new StaticElementsForPage(getDriver());
        findStaticElements = new FindStaticElements(getDriver());
        String adminLogin = getProperty("login");
        String adminPassword = getProperty("password");
        loginPage = new LoginPage(driver);
        loginPage.goToPage()
                .sendLogin(adminLogin)
                .pressButtonLogIn();
        filesPage = loginPage
                .sendPassword(adminPassword)
                .pressButtonLogIn();
        if (loginPage.isLoginPage()) {
            filesPage.goToPage();
        }
    }

    /**
     *
     */
    @AfterMethod
    public final void tearDown() {
        driver.quit();
    }
}

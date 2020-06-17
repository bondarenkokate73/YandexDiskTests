package tests.uiTests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pagesAndElements.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static helpers.ParametersProvider.getProperty;
import static helpers.WorkWithDriver.createDriver;

public class UiBaseTest {

    private WebDriver driver;

    public StaticElementsForPage staticElementsForPage;

    public FindStaticElements findStaticElements;

    public LoginPage loginPage;

    public FilesPage filesPage;

    public AlbumsPage albumsPage;

    public final WebDriver getDriver() {
        return driver;
    }

    public static final String HOME_PAGE_URL = "https://disk.yandex.ru/client";

    public final String workDirectory = "C:/Users/Kate/Downloads";
    public final String workFolder = "UiTestFolder";
    public WebElement workElement;
    public ContextMenuElements contextMenuElements;
    public List<String> filesOnPage;

    public List<String> downloadFiles;
    public final String path = "C:/";
    public final String nameFile = "Lancer.jpg";
    public File file;

    @Description("Uc01 - Авторизация в диске")
    @BeforeMethod
    public final void setEnvironment() throws IOException {
        driver = createDriver();
        //     driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        staticElementsForPage = new StaticElementsForPage(getDriver());
        findStaticElements = new FindStaticElements(getDriver());
        contextMenuElements = new ContextMenuElements(getDriver());
        albumsPage = new AlbumsPage(getDriver());
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

/*    @AfterMethod
    public void goToHomePage()
    {
        filesPage.goToPage();
    }*/

    @AfterMethod
    public final void tearDown() {
        driver.quit();
    }
}

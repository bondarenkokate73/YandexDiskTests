package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class WorkWithDriver {

    public final static WebDriver createDriver() throws IOException {
        WebDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String browserName = ParametersProvider.getProperty("browserName");
        boolean remote = Boolean.parseBoolean(ParametersProvider
                .getProperty("remote"));
        String seleniumUrl = ParametersProvider.getProperty("seleniumUrl");
        int pageLoadTimeout = Integer.parseInt(ParametersProvider
                .getProperty("pageLoadTimeout"));
        long implicitTimeout = Long.parseLong(ParametersProvider
                .getProperty("implicitTimeout"));
        if (remote) {
            capabilities.setBrowserName(browserName);
            capabilities.setCapability("enableVNC", Boolean
                    .valueOf(ParametersProvider.getProperty("enableVNC")));
            driver = new RemoteWebDriver(new URL(seleniumUrl), capabilities);
        } else {
            trySetDriverPath(browserName);
            if ("chrome".equals(browserName) || "opera".equals(browserName)) {
                driver = new ChromeDriver();
            } else if ("firefox".equals(browserName)) {
                driver = new FirefoxDriver();
            } else if ("edge".equals(browserName)) {
                driver = new EdgeDriver();
            } else {
                throw new IllegalStateException(
                        "Chosen browser not supported");
            }
        }
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout,
                TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(implicitTimeout,
                TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    private static void trySetDriverPath(final String browserName)
            throws IOException {
        String driverPath = ParametersProvider.getProperty("driverPath");
        if (driverPath != null && !driverPath.isEmpty()) {
            System.setProperty("webdriver." + browserName + ".driver",
                    driverPath);
        }
    }

    public final static void goToPage(
            final WebDriver driver,
            final String page) {
        driver.get(HOME_PAGE_URL + page);
    }

    public final static void goToPage(
            final String page,
            final WebDriver driver) {
        driver.get(page);
    }

    public final static String saveOldTab(
            final WebDriver driver) {
        return driver.getWindowHandle();
    }

    public final static void goToOldTab(
            final WebDriver driver,
            final String oldTab) {
        driver.close();
        driver.switchTo().window(oldTab);
    }

    public final static void contextClick(
            final WebElement element,
            final WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.contextClick(element);
    }

    public final static void refreshPage(
            final WebDriver driver) {
        driver.navigate().refresh();
    }

    public final static void goToRightTab(
            final WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public final static void closeThisTab(
            final WebDriver driver) {
        driver.close();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
}

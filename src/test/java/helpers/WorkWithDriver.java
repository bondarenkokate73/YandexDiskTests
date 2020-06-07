package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class WorkWithDriver {

    public final static void goToPage(
            final WebDriver driver,
            final String page) {
        driver.get(HOME_PAGE_URL + page);
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
}

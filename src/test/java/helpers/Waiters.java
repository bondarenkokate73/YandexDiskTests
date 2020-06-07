package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waiters {
    /**
     *
     */
    private static int timeout = 15;

    /**
     * Ожидание, пока элемент станет видимым.
     *
     * @param element /
     * @param driver  /
     */
    public static void waitUntilVisibility(
            final WebElement element,
            final WebDriver driver) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Ожидание, пока элемент станет кликабельным.
     *
     * @param element /
     * @param driver  /
     */
    public static void waitUntilElementToBeClickable(
            final WebElement element,
            final WebDriver driver) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Проверка, совпадает ли значение последнего элемента коллекции с нужным.
     * Пока нет, обновляем коллекцию.
     *
     * @param driver  /
     * @param value   /
     * @param element /
     */
    public static void waitUntilLastElementHasText(
            final By element,
            final String value,
            final WebDriver driver) {
        new WebDriverWait(driver, timeout)
                .until((ExpectedCondition<Boolean>) driver1 -> {
                    List<WebElement> elements = driver1
                            .findElements(element);
                    WebElement lastElement = elements
                            .get(elements.size() - 1);
                    return lastElement.getText().equals(value);
                });
    }

    /**
     * Ожидание, пока в коллекции не появится хоть один элемент.
     *
     * @param driver  driver
     * @param element element
     */
    public static void waitUntilElementsListNotEmpty(final WebDriver driver,
                                                     final By element) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(element,
                        0));
    }

    /**
     * Ожидание, пока элемент не появится в коллекции.
     *
     * @param element /
     * @param driver  /
     * @param value   /
     */
    public static void waitUntilCollectionContainsText(final WebDriver driver,
                                                       final List<WebElement> element,
                                                       final String value) {
        new WebDriverWait(driver, timeout)
                .until((ExpectedCondition<Boolean>) driver1 -> {
                    List<WebElement> elements = element;
                    for (WebElement elem : elements) {
                        if (elem.getText().equals(value)) {
                            return true;
                        }
                    }
                    return false;
                });
    }

    /**
     * Ожидание, пока элемент не пропадет из коллекции.
     *
     * @param element /
     * @param driver  /
     * @param value   /
     */
    public static void waitUntilCollectionNotContainsText(
            final WebDriver driver,
            final By element,
            final String value) {
        new WebDriverWait(driver, timeout)
                .until((ExpectedCondition<Boolean>) driver1 -> {
                    List<WebElement> elements = driver1
                            .findElements(element);
                    for (WebElement elem : elements) {
                        if (elem.getText().equals(value)) {
                            return false;
                        }
                    }
                    return true;
                });
    }

    /**
     *
     */
    public static void waitUntilElementContainsText(
            final WebElement element,
            final String value,
            final WebDriver driver) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.textToBePresentInElement(element, value));
    }

    /**
     *
     */
    public static void waitUntilUrlContainsText(
            final String url,
            final WebDriver driver) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.urlContains(url));
    }

}

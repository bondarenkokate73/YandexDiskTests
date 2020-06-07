package pagesAndElements;

import helpers.Waiters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextMenuElements {

    /**
     * Драйвер.
     */
    private WebDriver driver;

    /**
     * Кнопка Поделиться.
     */
    @FindBy(css = "div.resources-action-bar__side-right > span > button")
    private WebElement buttonShareElement;

    /**
     * Кнопка Скачать.
     */
    @FindBy(css = "div.resources-action-bar__side-right > button")
    private WebElement buttonDownloadElement;

    /**
     *
     */
    @FindBy(css = "div.groupable-buttons > div > span > div > button")
    private WebElement[] buttonsGroupableElement;

    /**
     * Контекстное меню кнопки поделиться.
     */
    @FindBy(css = "div.share-link-menu__outer-wrapper")
    private WebElement shareMenuElement;

    /**
     * Ссылка на опубликованный элемент.
     */
    @FindBy(css = "input.publish-resource-tumbler__input")
    private WebElement publishLinkElement;

    /**
     * Сообщение об ошибке.
     */
    @FindBy(css = "div.error__title")
    private WebElement errorMessageElement;

    /**
     * Папка для перемещения.
     */
    @FindBy(css = "div[data-key='view=treeWrap'] > div > div > div")
    private WebElement[] folderTransferElement;

    /**
     * Кнопка Переместить в окне выбора папки для перемещения.
     */
    @FindBy(css = ".confirmation-dialog__footer > button")
    private WebElement[] buttonModalWindowElement;

    /**
     * Конструктор контекстного меню.
     *
     * @param driver Драйвер.
     */
    public ContextMenuElements(final WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Нажатие кнопки Поделиться.
     */
    public void clickButtonShare() {
        buttonShareElement.click();
    }

    /**
     * Нажатие кнопки Скачать.
     */
    public void clickButtonDownload() {
        buttonDownloadElement.click();
    }

    /**
     * Нажатие кнопки Переименовать.
     */
    public void clickButtonRename() {
        buttonsGroupableElement[0].click();
    }

    /**
     * Нажатие кнопки Переместить.
     */
    public ContextMenuElements clickButtonTransfer() {
        buttonsGroupableElement[1].click();
        return this;
    }

    /**
     * Нажатие кнопки Удалить.
     */
    public void clickButtonDelete() {
        buttonsGroupableElement[2].click();
    }

    /**
     * Нажатие кнопки Копировать.
     */
    public ContextMenuElements clickButtonCopy() {
        buttonsGroupableElement[3].click();
        return this;
    }

    /**
     * Проверка появления меню после нажатия кнопки поделиться.
     */
    public Boolean isContextMenuVisible() {
        Waiters.waitUntilVisibility(
                shareMenuElement, driver);
        return shareMenuElement.isDisplayed();
    }

    /**
     * Получение ссылки на опубликованный элемент.
     */
    public String getPublishLink() {
        return publishLinkElement
                .getAttribute("readonly value");
    }

    /**
     * Проверка наличия ошибки на страницк опубликованного файла.
     */
    public Boolean isErrorMessageVisible(final String url) {
        Waiters.waitUntilUrlContainsText(url, driver);
        return errorMessageElement.isDisplayed();
    }

    /**
     * Выбор папки для перемещения.
     */
    public ContextMenuElements selectTransferFolder() {
        Waiters.waitUntilElementToBeClickable(
                folderTransferElement[3], driver);
        folderTransferElement[3].click();
        return this;
    }

    /**
     * Нажатие на кнопку Переместить.
     */
    public void clickButtonTransferElement()
    {
        buttonModalWindowElement[3].click();
    }

    /**
     * Нажатие на кнопку Копировать.
     */
    public ContextMenuElements clickButtonCopyElement()
    {
        buttonModalWindowElement[4].click();
        return this;
    }

    /**
     * Нажатие на кнопку Продолжить.
     */
    public void clickButtonContinueElement()
    {
        buttonModalWindowElement[2].click();
    }
}

package pagesAndElements;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContextMenuElements {

    private WebDriver driver;

    @FindBy(css = ".hover-tooltip__tooltip-anchor > button")
    private List<WebElement> buttonsGroupableElement;

    @FindBy(css = "div.share-link-menu__outer-wrapper")
    private WebElement shareMenuElement;

    @FindBy(css = "input.publish-resource-tumbler__input")
    private WebElement publishLinkElement;

    @FindBy(css = "div.error__title")
    private WebElement errorMessageElement;

    @FindBy(css = "div.b-tree__name")
    private List<WebElement> folderTransferElement;

    @FindBy(css = ".confirmation-dialog__footer > button")
    private List<WebElement> buttonModalWindowElement;

    @FindBy(css = "div.resources-action-bar__body")
    public WebElement contextBarElement;

    @FindBy(xpath = "//button[.//span//text()='Удалить']")
    public WebElement buttonDeleteElement;

    @FindBy(xpath = "//button[.//span//text()='Переместить']")
    public List<WebElement> buttonTransferElement;

    @FindBy(xpath = "//button[.//span//text()='Копировать']")
    public WebElement buttonCopyElement;

    @FindBy(xpath = "//button[.//span//text()='Переименовать']")
    public WebElement buttonRenameElement;

    @FindBy(xpath = "//button[.//span//text()='Скачать']")
    public WebElement buttonDownloadElement;

    @FindBy(xpath = "//button[.//span//text()='Поделиться']")
    public WebElement buttonShareElement;

    @FindBy(xpath = "//button[.//span//text()='Копировать']")
    public List<WebElement> buttonCopyApproveElement;

    @FindBy(xpath = "//button[.//span//text()='Продолжить']")
    public WebElement buttonContinueElement;

    public ContextMenuElements(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Нажатие кнопки Поделиться")
    public void clickButtonShare() {
        Waiters.waitUntilElementToBeClickable(buttonShareElement, driver);
        buttonShareElement.click();
    }

    @Step("Нажатие кнопки Скачать")
    public void clickButtonDownload() {
        Waiters.waitUntilElementToBeClickable(buttonDownloadElement, driver);
        buttonDownloadElement.click();
    }

    @Step("Нажатие кнопки Переименовать")
    public void clickButtonRename() {
        Waiters.waitUntilElementToBeClickable(buttonRenameElement, driver);
        buttonRenameElement.click();
    }

    @Step("Нажатие кнопки Переместить")
    public ContextMenuElements clickButtonTransfer() {
        Waiters.waitUntilElementToBeClickable(buttonTransferElement.get(0), driver);
        buttonTransferElement.get(0).click();
        return this;
    }

    @Step("Нажатие кнопки Удалить")
    public void clickButtonDelete() {
        Waiters.waitUntilElementToBeClickable(buttonDeleteElement, driver);
        buttonDeleteElement.click();
    }

    @Step("Нажатие кнопки Копировать")
    public ContextMenuElements clickButtonCopy() {
        Waiters.waitUntilElementToBeClickable(buttonCopyElement, driver);
        buttonCopyElement.click();
        return this;
    }

    @Step("Проверка появления меню после нажатия кнопки поделиться")
    public Boolean isContextMenuVisible() {
        Waiters.waitUntilVisibility(
                shareMenuElement, driver);
        return shareMenuElement.isDisplayed();
    }

    @Step("Получение ссылки на опубликованный элемент")
    public String getPublishLink() {
        return publishLinkElement
                .getAttribute("value");
    }

    @Step("Проверка наличия ошибки на странице опубликованного файла")
    public Boolean isPublicLink(final String link) {
        Waiters.waitUntilUrlContainsText("yadi.sk", driver);
        return link.contains("yadi.sk");
    }

    @Step("Выбор папки для перемещения")
    public ContextMenuElements selectTransferFolder(final String nameFolder) {
        WebElement folder = getFolderByName(folderTransferElement, nameFolder);
        Waiters.waitUntilElementToBeClickable(
                folder, driver);
        folder.click();
        return this;
    }

    @Step("Нажатие на кнопку Переместить")
    public void clickButtonTransferElement() {
        buttonTransferElement.get(0).click();
    }

    @Step("Нажатие на кнопку Копировать")
    public ContextMenuElements clickButtonCopyElement() {
        Waiters.waitUntilElementToBeClickable(
                buttonCopyApproveElement.get(1), driver);
        buttonCopyApproveElement.get(1).click();
        return this;
    }

    @Step("Нажатие на кнопку Продолжить")
    public void clickButtonContinueElement() {
        buttonContinueElement.click();
    }

    @Step("Проверка, выбран ли элемент")
    public Boolean isElementSelected(final WebElement element) {
        return element.getAttribute("class").contains("selected");
    }

    @Step("Получение элемента по названию папки")
    public WebElement getFolderByName(final List<WebElement> folders,
                                      final String name) {
        String nameFolder;
        for (WebElement element : folders) {
            nameFolder = element.getAttribute("title");
            if (nameFolder.equals(name)) {
                return element;
            }
        }
        return null;
    }

    @Step("Подтверждение пеемещения файла")
    public void clickButtonTransferInModalWindowElement() {
        buttonTransferElement.get(1).click();
    }
}

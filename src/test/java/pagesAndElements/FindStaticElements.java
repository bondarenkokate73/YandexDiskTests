package pagesAndElements;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Класс поиска статических элементов на странице.
 */
public class FindStaticElements {

    /**
     * Драйвер.
     */
    private WebDriver driver;

    /**
     * Конструктор класса поиска статических элементов на странице.
     */
    public FindStaticElements(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Форма поиска.
     */
    @FindBy(css = "form[class='search-input__form']")
    private WebElement formSearchElement;

    /**
     * Поле для ввода критериев поиска.
     */
    private By byInputSearchElement
            = By.cssSelector("input");

    @FindBy(css = "div[class='search__result']")
    private WebElement searchResultPanelElement;

    /**
     * Блок с кнопками Создать и Загрузить.
     */
    @FindBy(css = "div[class='sidebar__buttons']")
    private WebElement sidebarButtonsElement;

    /**
     * Кнопка загрузки.
     */
    @FindBy(css = "input[class='upload-button__attach']")
    private WebElement buttonDownloadElement;

    /**
     * Кнопка создания.
     */
    @FindBy(css = "span.create-resource-popup-with-anchor > button")
    private WebElement buttonCreateElement;


    /**
     * Блок с элементами создания.
     */
    @FindBy(css = "div[class='create-resource-popup-"
            + "with-anchor__create-items']")
    private WebElement sidebarButtonsCreateElement;

    /**
     * Кнопка создания папки.
     */
    @FindBy(xpath = "//button[.//span//text()='Папку']")
    private WebElement buttonCreateFolderElement;

    /**
     *
     */
    @FindBy(css = "form.rename-dialog__rename-form > span > input.textinput__control")
    private WebElement inputNameFolderElement;

    /**
     * Кнопка создания текстового документа.
     */
    @FindBy(xpath = "//button[.//span//text()='Текстовый документ']")
    private WebElement buttonCreateTextDocElement;

    /**
     * Кнопка создания таблицы.
     */
    @FindBy(xpath = "//button[.//span//text()='Таблицу']")
    private WebElement buttonCreateTableElement;

    /**
     * Кнопка создания презентации.
     */
    @FindBy(xpath = "//button[.//span//text()='Презентацию']")
    private WebElement buttonCreatePresentationElement;

    /**
     * Кнопка создания альбома.
     */
    @FindBy(xpath = "//button[.//span//text()='Альбом']")
    private WebElement buttonCreateAlbumElement;

    /**
     * Блок добавления места в диск.
     */
    @FindBy(css = "div[class='info-space__footer']")
    private WebElement footerAddSpaceElement;

    /**
     * Кнопка добавления места в диск.
     */
    private By byButtonAddSpaceElement
            = By.cssSelector("button[type='button']");

    /**
     * Блок с данными для скачивания приложения.
     */
    @FindBy(css = "div[class='sidebar__app-link-wrapper']")
    private WebElement footerDownloadAppElement;

    /**
     * Кнопка скачивания приложения.
     */
    private By byButtonDownloadApp = By.cssSelector("a");

    /**
     * Кнопка мееню "Последние".
     */
    @FindBy(css = "a[title='Последние']")
    private WebElement buttonPageLast;

    /**
     * Кнопка меню "Файлы".
     */
    @FindBy(css = "a[title='Файлы']")
    private WebElement buttonPageFiles;

    /**
     * Кнопка меню "Фото".
     */
    @FindBy(css = "a[title='Фото']")
    private WebElement buttonPagePhotos;

    /**
     * Кнопка меню "Альбомы".
     */
    @FindBy(css = "a[title='Альбомы']")
    private WebElement buttonPageAlbums;

    /**
     * Кнопка меню "Общий доступ".
     */
    @FindBy(css = "a[title='Общий доступ']")
    private WebElement buttonPagePublicAccess;

    /**
     * Кнопка меню "История".
     */
    @FindBy(css = "a[title='История']")
    private WebElement buttonPageHistory;

    /**
     * Кнопка меню "Архив".
     */
    @FindBy(css = "a[title='Архив']")
    private WebElement buttonPageArchive;

    /**
     * Кнопка меню "Корзина".
     */
    @FindBy(css = "a[title='Корзина']")
    private WebElement buttonPageTrash;

    /**
     * Кнопка меню "Загрузки".
     */
    @FindBy(css = "a[title='Загрузки']")
    private WebElement buttonPageDownload;

    /**
     * Кнопка Создание альбома.
     */
    @FindBy(css = "div.resources-action-bar__side-right > button")
    private WebElement buttonApprovedCreateAlbumElement;

    /**
     * Заголовок страницы.
     */
    @FindBy(tagName = "h1")
    public WebElement headerElement;

    /**
     * Кнопка Сохранить на форме ввода названия новой папки.
     */
    @FindBy(css = "div.confirmation-dialog__footer > button")
    public WebElement buttonSaveNewFolderElement;

    /**
     * Модальное окно создания элемента.
     */
    @FindBy(css = "div[class='create-resource-popup-with-anchor__title']")
    public WebElement modalWindowCreateElement;

    /**
     * Модальное окно загрузки файлов.
     */
    @FindBy(css = "div[class='uploader-progress']")
    public WebElement modalWindowDownloadFileElement;

    /**
     * Список загруженных файлов с модального окна.
     */
    @FindBy(xpath = "//*[@id=\"app\"]/div/div[6]/div[3]/div/div/div[2]/div/span")
    private List<WebElement> downloadFilesElements;

    /**
     * Кнопки Заменить и Не загружать при попытке загрузить существующий файл.
     */
    @FindBy(css = "div[class='upload-notification__button-group']")
    private WebElement buttonsDoubleFileElement;

    /**
     * Кнопка закрытия модального окна загрузки.
     */
    @FindBy(css = "div[class='uploader-progress__controls']")
    private WebElement buttonCloseModalWindowDownloadFilesElement;

    /**
     * Массив чекбоксов выбора фото в альбом.
     */
    @FindBy(css = "input.lite-checkbox__control")
    private List<WebElement> checkboxesPhoto;
    By byCheckboxesPhoto = By.cssSelector("input.lite-checkbox__control");

    /**
     * Названия файлов на странице.
     */
    @FindBy(css = "div[class='listing__items'] > div > div > div > span.clamped-text")
    private List<WebElement> namesOfFilesOnPageElements;
    By byNamesOfFilesOnPageElements = By.cssSelector("div[class='listing__items'] > div > div > div > span.clamped-text");

    /**
     * Получение элементов на странице.
     */
    @FindBy(css = "div.listing__items > div")
    private List<WebElement> filesOnPageElements;
    By byFilesOnPageElements = By.cssSelector("div.listing__items > div");

    /**
     * Кнопка Продолжить при создании Альбома.
     */
    @FindBy(xpath = "//button[./span//text()='Продолжить']")
    private WebElement buttonContinueCreateAlbumElement;

    /**
     * Зона для загрузки файлов.
     */
    @FindBy(css = "div[data-key='view=dropzone']")
    private WebElement dropzoneElement;

    /**
     * Имя элемента на странице.
     */
    private By nameOfElement = By.cssSelector("span.clamped-text");

    @Step("Получить кнопки Заменить и Не загружать при попытке загрузить сущесвующий файл.")
    public WebElement getButtonsDoubleFileElement() {
        return buttonsDoubleFileElement;
    }

    @Step("Получить поле ввода названия новой папки.")
    public WebElement getInputNameFolder() {
        Waiters.waitUntilElementToBeClickable(
                inputNameFolderElement, driver);
        return inputNameFolderElement;
    }

    @Step("Получить модальное окно создания элемента.")
    public WebElement getModalWindowCreateElement() {
        Waiters.waitUntilVisibility(
                modalWindowCreateElement, driver);
        return modalWindowCreateElement;
    }

    @Step("Получить кнопку закрытия модального окна загрузки файлов.")
    public WebElement getButtonCloseModalWindowDownloadFilesElement() {
        return buttonCloseModalWindowDownloadFilesElement
                .findElement(By.tagName("button"));
    }

    @Step("Получение списка загруженных файлов.")
    public List<WebElement> getListDownloadFiles() {
        return downloadFilesElements;
    }

    @Step("Кнопка Сохранить на форме ввода названия новой папки.")
    WebElement getButtonSaveNewFolderElement() {
        Waiters.waitUntilElementToBeClickable(
                buttonSaveNewFolderElement, driver);
        return buttonSaveNewFolderElement;
    }

    @Step("Получение модального окна загрузки файлов.")
    WebElement getModalWindowDownloadFileElement() {
        return modalWindowDownloadFileElement;
    }

    @Step("Получение элемента поля поиска.")
    public WebElement getInputSearchElement() {
        Waiters.waitUntilElementToBeClickable(
                formSearchElement, driver);
        return formSearchElement
                .findElement(byInputSearchElement);
    }

    @Step("Получение панели с результатами поиска.")
    WebElement getSearchResultPanelElement() {
        Waiters.waitUntilVisibility(
                searchResultPanelElement, driver);
        return searchResultPanelElement;
    }

    @Step("Получение кнопки загрузки.")
    WebElement getButtonDownload() {
        return buttonDownloadElement;
    }

    @Step("Получение кнопки создания.")
    WebElement getButtonCreate() {
        Waiters.waitUntilElementToBeClickable(
                buttonCreateElement, driver);
        return buttonCreateElement;
    }

    @Step("Получение кнопки создания папки.")
    WebElement getButtonCreateFolder() {
        Waiters.waitUntilVisibility(
                sidebarButtonsCreateElement, driver);
        return buttonCreateFolderElement;
    }

    @Step("Получене кнопки создания текстового документа.")
    WebElement getButtonCreateTextDoc() {
        Waiters.waitUntilElementToBeClickable(buttonCreateTextDocElement, driver);
        return buttonCreateTextDocElement;
    }

    @Step("Получение кнопки создания таблицы.")
    WebElement getButtonCreateTable() {
        Waiters.waitUntilElementToBeClickable(buttonCreateTableElement, driver);
        return buttonCreateTableElement;
    }

    @Step("Получение кнопки создания презентации.")
    WebElement getButtonCreatePresentation() {
        Waiters.waitUntilElementToBeClickable(buttonCreatePresentationElement, driver);
        return buttonCreatePresentationElement;
    }

    @Step("Получение кнопки создания альбома.")
    WebElement getButtonCreateAlbum() {
        Waiters.waitUntilElementToBeClickable(buttonCreateAlbumElement, driver);
        return buttonCreateAlbumElement;
    }

    @Step("Получение кнопки добавления места в диск.")
    WebElement getButtonAddSpace() {
        return footerAddSpaceElement
                .findElement(byButtonAddSpaceElement);
    }

    @Step("Получение кнопки скачивания приложения.")
    WebElement getButtonDownloadApp() {
        return footerDownloadAppElement
                .findElement(byButtonDownloadApp);
    }

    @Step("Получение кнопки перехода на страницу Последние.")
    WebElement getButtonPageLast() {
        Waiters.waitUntilVisibility(
                buttonPageLast, driver);
        return buttonPageLast;
    }

    @Step("Получение кнопки перехода на страницу Файлы.")
    WebElement getButtonPageFiles() {
        Waiters.waitUntilVisibility(
                buttonPageFiles, driver);
        return buttonPageFiles;
    }

    @Step("Получение кнопки перехода на страницу Фото.")
    WebElement getButtonPagePhotos() {
        Waiters.waitUntilVisibility(
                buttonPagePhotos, driver);
        return buttonPagePhotos;
    }

    @Step("Получение кнопки перехода на страницу Альбомы.")
    WebElement getButtonPageAlbums() {
        Waiters.waitUntilVisibility(
                buttonPageAlbums, driver);
        return buttonPageAlbums;
    }

    @Step("Получение кнопки перехода на страницу Общий доступ.")
    WebElement getButtonPagePublicAccess() {
        Waiters.waitUntilVisibility(
                buttonPagePublicAccess, driver);
        return buttonPagePublicAccess;
    }

    @Step("Получение кнопки перехода на страницу История.")
    WebElement getButtonPageHistory() {
        Waiters.waitUntilVisibility(
                buttonPageHistory, driver);
        return buttonPageHistory;
    }

    @Step("Получение кнопки перехода на страницу Архив.")
    WebElement getButtonPageArchive() {
        Waiters.waitUntilVisibility(
                buttonPageArchive, driver);
        return buttonPageArchive;
    }

    @Step("Получение кнопки перехода на страницу Корзина.")
    WebElement getButtonPageTrash() {
        Waiters.waitUntilVisibility(
                buttonPageTrash, driver);
        return buttonPageTrash;
    }

    @Step("Получение кнопки перехода на страницу Загрузки.")
    WebElement getButtonPageDownload() {
        Waiters.waitUntilVisibility(
                buttonPageDownload, driver);
        return buttonPageDownload;
    }

    @Step("Получение файлов на странице.")
    public List<WebElement> getNamesFilesOnPage() {
        return namesOfFilesOnPageElements;
    }

    @Step("Получение файлов на странице.")
    List<WebElement> getNamesFilesOnPage(final String file) {
        try {
            Waiters.waitUntilCollectionContainsText(driver, byNamesOfFilesOnPageElements, file);
            return namesOfFilesOnPageElements;
        } catch (Exception ex) {
            return null;
        }
    }

    @Step("Получение кнопки Продолжить на форме ввода названия нового альбома.")
    public WebElement getButtonContinueCreateAlbumElement() {
        Waiters.waitUntilElementToBeClickable(
                buttonContinueCreateAlbumElement, driver);
        return buttonContinueCreateAlbumElement;
    }

    @Step("Получение чекбокса первого фото.")
    public WebElement getCheckboxPhoto() {
        Waiters.waitUntilUrlContainsText(
                "Ccreate-album", driver);
        Waiters.waitUntilElementsListNotEmpty(driver, byCheckboxesPhoto);
        return checkboxesPhoto.get(1);
    }

    @Step("Получение кнопки Создать альбом.")
    public WebElement getButtonApprovedCreateAlbumElement() {
        Waiters.waitUntilElementToBeClickable(
                buttonApprovedCreateAlbumElement, driver);
        return buttonApprovedCreateAlbumElement;
    }

    @Step("Получение файлов на странице")
    public List<WebElement> getFilesOnPage() {
        return filesOnPageElements;
    }

    @Step("Поиск элемента по имени.")
    public WebElement getElementOfName(final String name) {
        String nameElement;
        Waiters.waitUntilCollectionContainsText(driver, byNamesOfFilesOnPageElements, name);
        for (WebElement element : getFilesOnPage()) {
            try {
                nameElement = element.findElement(nameOfElement).getText();
                if (nameElement.equals(name)) {
                    return element;
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    @Step("Поиск элемента по имени.")
    public WebElement getElementContainsName(final String name) {
        String nameElement;
        //  Waiters.waitUntilCollectionContainsText(driver, byNamesOfFilesOnPageElements, name);
        for (WebElement element : getFilesOnPage()) {
            try {
                nameElement = element.findElement(nameOfElement).getText();
                if (nameElement.contains(name)) {
                    return element;
                }
            } catch (Exception ex) {
            }
        }
        return null;
    }

    @Step("Получение зоны загрузки файлов.")
    public WebElement getDropzoneElement() {
        return dropzoneElement;
    }
}

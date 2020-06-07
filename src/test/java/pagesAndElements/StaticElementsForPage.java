package pagesAndElements;

import helpers.Waiters;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static helpers.JavaScriptExecutorHelper.dropFile;

/**
 * Статические элементы каждой страницы.
 */
public class StaticElementsForPage {

    /**
     * Драйвер.
     */
    private WebDriver driver;

    /**
     * Класс поиска статических элементов.
     */
    private FindStaticElements findStaticElements;

    /**
     * Конструктор класса.
     */
    public StaticElementsForPage(final WebDriver driver) {
        this.driver = driver;
        findStaticElements = new FindStaticElements(driver);
    }

    /**
     * Поиск элемента.
     */
    public void search(final String text) {
        findStaticElements.getInputSearchElement()
                .sendKeys(text + Keys.ENTER);
    }

    /**
     * Проверка наличия панели поиска.
     */
    public Boolean isSearchResultPanelDisplayed() {
        return findStaticElements.getSearchResultPanelElement()
                .isDisplayed();
    }

    /**
     * Загрузка файлов на диск.
     */
    public void downloadFileOnDisk(final File file) {
        findStaticElements.getButtonDownload()
                .sendKeys(file.getAbsolutePath()
                        + Keys.ENTER);
    }

    /**
     * Нажатие на кнопку Создать.
     */
    public void clickButtonCreate() {
        findStaticElements.getButtonCreate()
                .click();
    }

    /**
     * Нажатие на кнопку создания папки.
     */
    public StaticElementsForPage clickButtonCreateFolder() {
        findStaticElements.getButtonCreateFolder()
                .click();
        return this;
    }

    /**
     * Нажатие на кнопку текстового документа.
     */
    public StaticElementsForPage clickButtonCreateTextDoc() {
        findStaticElements.getButtonCreateTextDoc()
                .click();
        return this;
    }

    /**
     * Нажатие на кнопку создания таблицы.
     */
    public void clickButtonCreateTable() {
        findStaticElements.getButtonCreateTable()
                .click();
    }

    /**
     * Нажатие на кнопку создания презентации.
     */
    public void clickButtonCreatePresentation() {
        findStaticElements.getButtonCreatePresentation()
                .click();
    }

    /**
     * Нажатие на кнопку создания альбома.
     */
    public StaticElementsForPage clickButtonCreateAlbum() {
        findStaticElements.getButtonCreateAlbum()
                .click();
        return this;
    }

    /**
     * Нажатие на кнопку добавления места в диск.
     */
    public void clickButtonAddSpace() {
        findStaticElements.getButtonAddSpace()
                .click();
    }

    /**
     * Нажатие на кнопку скачать приложение.
     */
    public void clickButtonDownloadApp() {
        findStaticElements.getButtonDownloadApp()
                .click();
    }

    /**
     * Нажатие на кнопку перехода на страницу Последние.
     */
    public LastPage clickButtonPageLast() {
        findStaticElements.getButtonPageLast()
                .click();
        return new LastPage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу Файлы.
     */
    public FilesPage clickButtonPageFiles() {
        findStaticElements.getButtonPageFiles()
                .click();
        return new FilesPage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу Фото.
     */
    public PhotosPage clickButtonPagePhotos() {
        findStaticElements.getButtonPagePhotos()
                .click();
        return new PhotosPage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу Альбомы.
     */
    public AlbumsPage clickButtonPageAlbums() {
        findStaticElements.getButtonPageAlbums()
                .click();
        return new AlbumsPage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу Общий доступ.
     */
    public PublicAccessPage clickButtonPagePublicAccess() {
        findStaticElements.getButtonPagePublicAccess()
                .click();
        return new PublicAccessPage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу История.
     */
    public HistoryPage clickButtonPageHistory() {
        findStaticElements.getButtonPageHistory()
                .click();
        return new HistoryPage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу Архив.
     */
    public ArchivePage clickButtonPageArchive() {
        findStaticElements.getButtonPageArchive()
                .click();
        return new ArchivePage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу Корзины.
     */
    public TrashPage clickButtonPageTrash() {
        findStaticElements.getButtonPageTrash()
                .click();
        return new TrashPage(driver);
    }

    /**
     * Нажатие на кнопку перехода на страницу Загрузок.
     */
    public DownloadPage clickButtonPageDownload() {
        findStaticElements.getButtonPageDownload()
                .click();
        return new DownloadPage(driver);
    }

    /**
     * Получение заголовка страницы.
     */
    public String getHeader(final String text) {
        Waiters
                .waitUntilElementContainsText(
                        findStaticElements.headerElement,
                        text,
                        driver);
        return findStaticElements.headerElement.getText();
    }

    /**
     * Проверка появилось ли модальное окно загрузки файлов.
     */
    public Boolean isModalWindowDownloadFileDisplayed() {
        Waiters.waitUntilVisibility(findStaticElements
                .getModalWindowDownloadFileElement(), driver);
        return findStaticElements.getModalWindowDownloadFileElement().isDisplayed();
    }

    /**
     * Получение списка имен скачанных файлов.
     */
    public List<String> getNamesOfDownloadFiles() {
        List<String> result = new ArrayList<>();
        for (WebElement element :
                findStaticElements.getListDownloadFiles()) {
            result.add(element.getText());
        }
        return result;
    }

    /**
     * Проверка существует ли загружаемый файл.
     */
    public Boolean isFileIsDouble() {
        return findStaticElements
                .getButtonsDoubleFileElement()
                .isDisplayed();
    }

    /**
     * Проверка открытия модального окна создания файлов.
     */
    public Boolean isModalWindowCreateOpen() {
        return findStaticElements
                .getModalWindowCreateElement()
                .isDisplayed();
    }

    /**
     * Поиск нужных файлов на странице.
     */
    public Boolean isListContainsElement(
            final List<String> searchResults,
            final String name) {
        for (String element : searchResults) {
            if (element.contains(name)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     * Закрытие модального окна загрузки файлов.
     */
    public void closeModalWindowDownloadFiles() {
        findStaticElements
                .getButtonCloseModalWindowDownloadFilesElement()
                .click();
    }


    /**
     * Получение списка файлов на странице.
     */
    public List<String> getFilesOnPage() {
        List<String> result = new ArrayList<>();
        for (WebElement element
                : findStaticElements.getNamesFilesOnPage()) {
            result.add(element.getText());
        }
        return result;
    }

    /**
     * Получение списка файлов на странице с ожиданием появления конкретного файла.
     */
    public List<String> getFilesOnPage(final String text) {
        List<String> result = new ArrayList<>();
        for (WebElement element
                : findStaticElements.getNamesFilesOnPage(text)) {
            result.add(element.getText());
        }
        return result;
    }

    /**
     * Получение поля для ввода имени новой папки.
     */
    public StaticElementsForPage inputNameFolder(final String name) {
        for (Integer p = 0; p < 12; p++) {
            findStaticElements
                    .getInputNameFolder().sendKeys(Keys.BACK_SPACE);
        }
        findStaticElements
                .getInputNameFolder()
                .sendKeys(name);
        return this;
    }

    /**
     * Нажатие на кнопку Сохранить в окне создания новой папки.
     */
    public StaticElementsForPage clickButtonSaveFolder() {
        findStaticElements
                .getButtonSaveNewFolderElement()
                .click();
        return this;
    }

    /**
     * Нажатие на кнопку Продолжить в окне создания альбома.
     */
    public StaticElementsForPage clickButtonContinueCreateAlbum() {
        findStaticElements
                .getButtonContinueCreateAlbumElement()
                .click();
        return this;
    }

    /**
     * Активация чекбокса первого фото.
     */
    public StaticElementsForPage clickCheckboxPhoto() {
        findStaticElements
                .getCheckboxPhoto()
                .click();
        return this;
    }

    /**
     * Нажатие на кнопку Создать альбом.
     */
    public StaticElementsForPage clickButtonCreateAlbumElement() {
        findStaticElements
                .getButtonCreateAlbumElement()
                .click();
        return this;
    }

    /**
     * Проверка нахождения на нужной странице.
     */
    public Boolean isPageContainsUrl(final String urlPage) {
        Waiters.waitUntilUrlContainsText(
                urlPage, driver);
        return driver.getCurrentUrl().contains(urlPage);
    }

    /**
     * Загрузка файла методом перетаскивания в браузер.
     */
    public void downloadFileDragAndDrop(final String path) {
        dropFile(findStaticElements.getDropzoneElement(), path);
    }
}

package pagesAndElements;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static helpers.JavaScriptExecutorHelper.dropFile;

public class StaticElementsForPage {

    private WebDriver driver;

    private FindStaticElements findStaticElements;

    public StaticElementsForPage(final WebDriver driver) {
        this.driver = driver;
        findStaticElements = new FindStaticElements(driver);
    }

    @Step("Поиск элемента по диску")
    public void search(final String text) {
        cleanInput(findStaticElements.getInputSearchElement()).sendKeys(text + Keys.ENTER);
    }

    @Step("Проверка наличия панели поиска")
    public Boolean isSearchResultPanelDisplayed() {
        return findStaticElements.getSearchResultPanelElement()
                .isDisplayed();
    }

    @Step("Загрузка файлов на диск")
    public void downloadFileOnDisk(final File file) {
        findStaticElements.getButtonDownload()
                .sendKeys(file.getAbsolutePath());
    }

    @Step("Нажатие на кнопку Создать")
    public StaticElementsForPage clickButtonCreate() {
        findStaticElements.getButtonCreate()
                .click();
        return this;
    }

    @Step("Нажатие на кнопку создания папки")
    public StaticElementsForPage clickButtonCreateFolder() {
        findStaticElements.getButtonCreateFolder()
                .click();
        return this;
    }

    @Step("Нажатие на кнопку текстового документа")
    public StaticElementsForPage clickButtonCreateTextDoc() {
        findStaticElements.getButtonCreateTextDoc()
                .click();
        return this;
    }

    @Step("Нажатие на кнопку создания таблицы")
    public void clickButtonCreateTable() {
        findStaticElements.getButtonCreateTable()
                .click();
    }

    @Step("Нажатие на кнопку создания презентации")
    public void clickButtonCreatePresentation() {
        findStaticElements.getButtonCreatePresentation()
                .click();
    }

    @Step("Нажатие на кнопку создания альбома")
    public StaticElementsForPage clickButtonCreateAlbum() {
        findStaticElements.getButtonCreateAlbum()
                .click();
        return this;
    }

    @Step("Нажатие на кнопку добавления места в диск")
    public void clickButtonAddSpace() {
        findStaticElements.getButtonAddSpace()
                .click();
    }

    @Step("Нажатие на кнопку скачать приложение")
    public void clickButtonDownloadApp() {
        findStaticElements.getButtonDownloadApp()
                .click();
    }

    @Step("Нажатие на кнопку перехода на страницу Последние")
    public LastPage clickButtonPageLast() {
        findStaticElements.getButtonPageLast()
                .click();
        return new LastPage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу Файлы")
    public FilesPage clickButtonPageFiles() {
        findStaticElements.getButtonPageFiles()
                .click();
        return new FilesPage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу Фото")
    public PhotosPage clickButtonPagePhotos() {
        findStaticElements.getButtonPagePhotos()
                .click();
        return new PhotosPage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу Альбомы")
    public AlbumsPage clickButtonPageAlbums() throws InterruptedException {
        Thread.sleep(1000);
        findStaticElements.getButtonPageAlbums()
                .click();
        return new AlbumsPage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу Общий доступ")
    public PublicAccessPage clickButtonPagePublicAccess() {
        findStaticElements.getButtonPagePublicAccess()
                .click();
        return new PublicAccessPage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу История")
    public HistoryPage clickButtonPageHistory() {
        findStaticElements.getButtonPageHistory()
                .click();
        return new HistoryPage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу Архив")
    public ArchivePage clickButtonPageArchive() {
        findStaticElements.getButtonPageArchive()
                .click();
        return new ArchivePage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу Корзины")
    public TrashPage clickButtonPageTrash() {
        findStaticElements.getButtonPageTrash()
                .click();
        return new TrashPage(driver);
    }

    @Step("Нажатие на кнопку перехода на страницу Загрузок")
    public DownloadPage clickButtonPageDownload() {
        findStaticElements.getButtonPageDownload()
                .click();
        return new DownloadPage(driver);
    }

    @Step("Получение заголовка страницы")
    public String getHeader(final String text) {
        Waiters
                .waitUntilElementContainsText(
                        findStaticElements.headerElement,
                        text,
                        driver);
        return findStaticElements.headerElement.getText();
    }

    @Step("Проверка появилось ли модальное окно загрузки файлов")
    public Boolean isModalWindowDownloadFileDisplayed() {
        Waiters.waitUntilVisibility(findStaticElements
                .getModalWindowDownloadFileElement(), driver);
        return findStaticElements.getModalWindowDownloadFileElement().isDisplayed();
    }

    @Step("Получение списка имен скачанных файлов")
    public List<String> getNamesOfDownloadFiles() {
        List<String> result = new ArrayList<String>();
        for (WebElement element :
                findStaticElements.getListDownloadFiles()) {
            result.add(element.getText());
        }
        return result;
    }

    @Step("Проверка существует ли загружаемый файл")
    public Boolean isFileIsDouble() {
        return findStaticElements
                .getButtonsDoubleFileElement()
                .isDisplayed();
    }

    @Step("Проверка открытия модального окна создания файлов")
    public Boolean isModalWindowCreateOpen() {
        return findStaticElements
                .getModalWindowCreateElement()
                .isDisplayed();
    }

    @Step("Поиск нужных файлов на странице")
    public Boolean isListEqualsElement(
            final List<String> searchResults,
            final String name) {
        for (String element : searchResults) {
            if (element.equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Step("Поиск нужных файлов на странице")
    public Boolean isListContainsElement(
            final List<String> searchResults,
            final String name) {
        for (String element : searchResults) {
            if (element.contains(name)) {
                return true;
            }
        }
        return false;
    }

    @Step("Закрытие модального окна загрузки файлов")
    public void closeModalWindowDownloadFiles() {
        findStaticElements
                .getButtonCloseModalWindowDownloadFilesElement()
                .click();
    }

    @Step("Получение списка файлов на странице")
    public List<String> getFilesOnPage() {
        List<String> result = new ArrayList<String>();
        for (WebElement element
                : findStaticElements.getNamesFilesOnPage()) {
            result.add(element.getText());
        }
        return result;
    }

    @Step("Получение списка файлов на странице")
    public Boolean isTrashClean() {
        try {
            Waiters.waitUntilElementsListEmpty(driver, findStaticElements.byNamesOfFilesOnPageElements);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Step("Получение списка файлов на странице с ожиданием появления конкретного файла")
    public List<String> getFilesOnPage(final String text) {
        List<String> result = new ArrayList<String>();
        for (WebElement element
                : findStaticElements.getNamesFilesOnPage(text)) {
            result.add(element.getText());
        }
        return result;
    }

    @Step("Получение поля для ввода имени новой папки")
    public StaticElementsForPage inputNameFolder(final String name) {
        cleanInput(findStaticElements.getInputNameFolder()).sendKeys(name);
        return this;
    }

    @Step("Очистка поля")
    public WebElement cleanInput(final WebElement input) {
        for (Integer p = 0; p < 12; p++) {
            input.sendKeys(Keys.BACK_SPACE);
        }
        return input;
    }

    @Step("Нажатие на кнопку Сохранить в окне создания новой папки")
    public StaticElementsForPage clickButtonSaveFolder() {
        findStaticElements
                .getButtonSaveNewFolderElement()
                .click();
        return this;
    }

    @Step("Нажатие на кнопку Продолжить в окне создания альбома")
    public StaticElementsForPage clickButtonContinueCreateAlbum() {
        findStaticElements
                .getButtonContinueCreateAlbumElement()
                .click();
        return this;
    }

    @Step("Активация чекбокса первого фото")
    public StaticElementsForPage clickCheckboxPhoto() {
        findStaticElements
                .getCheckboxPhoto()
                .click();
        return this;
    }

    @Step("Нажатие на кнопку Создать альбом")
    public StaticElementsForPage clickButtonCreateAlbumElement() {
        findStaticElements
                .getButtonApprovedCreateAlbumElement()
                .click();
        return this;
    }

    @Step("Проверка нахождения на нужной странице")
    public Boolean isPageContainsUrl(final String urlPage) {
        Waiters.waitUntilUrlContainsText(
                urlPage, driver);
        return driver.getCurrentUrl().contains(urlPage);
    }

    @Step("Загрузка файла методом перетаскивания в браузер")
    public void downloadFileDragAndDrop(final String path) {
        dropFile(findStaticElements.getDropzoneElement(), path);
    }

    @Step("Проверка удаления элемента")
    public Boolean isElementDelete(final List<WebElement> collection,
                                   final String file) {
        try {
            Waiters.waitUntilCollectionNotContainsText(
                    driver, collection, file);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}

package pagesAndElements;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class FilesPage {

    private WebDriver driver;

    public static final String FILES_PAGE_URL = "/disk";


    public StaticElementsForPage staticElementsForPage;

    public final String PAGE_HEADER = "Файлы";

    public FilesPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + FILES_PAGE_URL);
        Waiters.waitUntilUrlContainsText(FILES_PAGE_URL, driver);
        return new FilesPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public Boolean isFilesPage() {
        return getUrl().contains(FILES_PAGE_URL);
    }

    @Step("Получение заголовка на странице")
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }

    @Step("Создание рабочей папки")
    public Boolean createWorkFolder(final String name) {
        staticElementsForPage.clickButtonCreate();
        if (staticElementsForPage.isModalWindowCreateOpen()) {
            staticElementsForPage
                    .clickButtonCreateFolder()
                    .inputNameFolder(name)
                    .clickButtonSaveFolder();
            return true;
        }
        return false;
    }
}

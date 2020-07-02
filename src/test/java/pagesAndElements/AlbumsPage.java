package pagesAndElements;

import helpers.Waiters;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static tests.uiTests.UiBaseTest.HOME_PAGE_URL;

public class AlbumsPage {

    private WebDriver driver;

    public static final String ALBUMS_PAGE_URL = "/albums";

    public StaticElementsForPage staticElementsForPage;

    public final String PAGE_HEADER = "Альбомы";

    @FindBy(xpath = "//div[./pre//text()='Новый альбом']/parent::node()/parent::node()/parent::node()")
    public List<WebElement> newAlbumElement;
    By byNewAlbumElement = By.cssSelector("//div[./pre//text()='Новый альбом']/parent::node()/parent::node()/parent::node()");

    @FindBy(css = "div.section-header__controls-wrapper > div > button")
    public List<WebElement> buttonEtc;

    @FindBy(xpath = "//div[./span//text()='Удалить']")
    public WebElement buttonDeleteAlbum;

    @FindBy(xpath = "//button[./span//text()='Удалить']")
    public WebElement buttonApprovedDelete;

    public AlbumsPage(final WebDriver webDriver) {
        this.driver = webDriver;
        staticElementsForPage = new StaticElementsForPage(driver);
        PageFactory.initElements(webDriver, this);
    }

    public FilesPage goToPage() {
        driver.navigate().to(HOME_PAGE_URL + ALBUMS_PAGE_URL);
        return new FilesPage(driver);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public Boolean isAlbumsPage() {
        return getUrl().contains(ALBUMS_PAGE_URL);
    }

    @Step("Получение заголовка на странице")
    public String getHeader() {
        return staticElementsForPage
                .getHeader(PAGE_HEADER);
    }

    @Step("Получение элемента Новый альбом")
    public WebElement getAlbum() {
        List<WebElement> element = newAlbumElement;
        if (element.isEmpty()) {
            return null;
        } else {
            return element.get(0);
        }
    }

    @Step("Получение элемента Новый альбом")
    public WebElement getAlbum(final String nameAlbum) throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> element = newAlbumElement;
        try {
      //      Waiters.waitUntilCollectionContainsText(driver, byNewAlbumElement, nameAlbum);
            return element.get(0);
        } catch (Exception ex) {
            return null;
        }
    }

    @Step("Нажатие на кнопку Ещё на альбоме")
    public AlbumsPage clickButtonEtc() {
        Waiters.waitUntilElementToBeClickable(buttonEtc.get(1), driver);
        buttonEtc.get(1).click();
        return this;
    }

    @Step("Нажатие на кнопку Удалить альбом")
    public AlbumsPage clickButtonDelete() {
        Waiters.waitUntilElementToBeClickable(buttonDeleteAlbum, driver);
        buttonDeleteAlbum.click();
        return this;
    }

    @Step("Кнопка подтвеждения удаления альбома")
    public void clickButtonApprovedDelete() {
        Waiters.waitUntilElementToBeClickable(buttonApprovedDelete, driver);
        buttonApprovedDelete.click();
    }
}

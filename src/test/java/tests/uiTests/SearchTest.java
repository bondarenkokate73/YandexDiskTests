package tests.uiTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pagesAndElements.SearchResultPage;

import java.util.List;

public class SearchTest extends UiBaseTest {

    SearchResultPage searchResultPage;

    @BeforeMethod
    public void before() {
        searchResultPage = new SearchResultPage(getDriver());
    }

    @Description("Uc11 - Поиск по диску")
    @Test
    public void searchFileTest() {
        SoftAssert softAssert = new SoftAssert();
        final String textForSearch = "Загрузки";
        staticElementsForPage.search(textForSearch);
        softAssert.assertEquals(searchResultPage.PAGE_HEADER,
                searchResultPage.getHeader(),
                "Страница не содержит нужного заголовка.");
        List<String> result = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(staticElementsForPage
                        .isListContainsElement(result, textForSearch),
                "В результате поиска не было найдено файла с нужным именем.");
        softAssert.assertAll();
    }

    @Description("Uc12 - Поиск по диску с английской раскладкой")
    @Test
    public void searchFileWithEnglishLayoutTest() {
        SoftAssert softAssert = new SoftAssert();
        final String textForSearchEnglishLayout = "Pfuheprb";
        final String textForSearch = "Загрузки";
        staticElementsForPage.search(textForSearchEnglishLayout);
        softAssert.assertEquals(searchResultPage.PAGE_HEADER,
                searchResultPage.getHeader(),
                "Страница не содержит нужного заголовка.");
        List<String> result = staticElementsForPage.getFilesOnPage();
        softAssert.assertTrue(staticElementsForPage
                        .isListContainsElement(result, textForSearch),
                "В результате поиска не было найдено файла с нужным именем.");
        softAssert.assertAll();
    }

    @Description("Uc13 - Поиск по диску несуществующего файла")
    @Test
    public void searchNotExistFileTest() {
        SoftAssert softAssert = new SoftAssert();
        final String textForSearch = "Ульяновск.jpg";
        staticElementsForPage.search(textForSearch);
        List<String> result = staticElementsForPage.getFilesOnPage();
        softAssert.assertFalse(staticElementsForPage
                        .isListContainsElement(result, textForSearch),
                "В результате поиска не было найдено файла с нужным именем.");
        softAssert.assertAll();
    }

}

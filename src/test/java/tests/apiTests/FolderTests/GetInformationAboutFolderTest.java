package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import static helpers.RestAssuredHelper.getValueFromJson;

public class GetInformationAboutFolderTest extends ApiBaseTest {

    @Description("Ac06 - Получение информации о папке")
    @Test
    public void getInformationAboutFolderTest() {
        folder = "Загрузки";
        response = apiMethods
                .getInformationAboutFolder(folder);
        Assert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode());
        Assert.assertEquals(folder,
                getValueFromJson(response, "name"),
                "Получена некорректная информация.");
    }

    @Description("Ac07 - Получение информации о несуществующей папке")
    @Test
    public void getInformationAboutNotExistsFolderTest() {
        folder = "НеведомаяНесуществующаяПапка";
        response = apiMethods
                .getInformationAboutFolder(folder);
        Assert.assertEquals(response.getStatusCode(), 404,
                "Запрос вернул код " + response.getStatusCode());
    }


}

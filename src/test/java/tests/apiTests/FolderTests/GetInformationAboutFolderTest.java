package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class GetInformationAboutFolderTest extends ApiBaseTest {

    public GetInformationAboutFolderTest() throws IOException {
    }

    @Description("Ac06 - Получение информации о папке")
    @Test
    public void getInformationAboutFolderTest() {
        workFolder = "Загрузки";
        response = apiMethods
                .getInformationAboutFolder(workFolder);
        Assert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        Assert.assertEquals(workFolder,
                getValueFromJson(response, "name"),
                "Получена некорректная информация.");
    }

    @Description("Ac07 - Получение информации о несуществующей папке")
    @Test
    public void getInformationAboutNotExistsFolderTest() {
        workFolder = "НеведомаяНесуществующаяПапка";
        response = apiMethods
                .getInformationAboutFolder(workFolder);
        Assert.assertEquals(response.getStatusCode(), 404,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }


}

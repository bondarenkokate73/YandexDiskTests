package tests.apiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static helpers.RestAssuredHelper.getValueFromJson;

public class FilesTest extends ApiBaseTest {

    //загрузка файла на диск, если его не существует

    @Description("Ac04 - Получение информации о файле")
    @Test
    public void getInformationAboutFileTest() {
        final String folder = "/";
        final String nameFile = "logo.png";
        response = apiMethods
                .getInformationAboutFile(folder, nameFile);
        Assert.assertEquals(
                response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode());
        Assert.assertEquals(nameFile,
                getValueFromJson(response, "name"),
                "Получена некорректная информация.");
    }

    @Description("Ac05 - Получение информации о несуществующем файле")
    @Test
    public void getInformationAboutNotExistsFileTest() {
        final String folder = "/";
        final String nameFile = "АбсолютноНесуществующийФайл.пнг";
        response = apiMethods
                .getInformationAboutFile(folder, nameFile);
        Assert.assertEquals(
                response.getStatusCode(), 404,
                "Запрос вернул код " + response.getStatusCode());
    }
}

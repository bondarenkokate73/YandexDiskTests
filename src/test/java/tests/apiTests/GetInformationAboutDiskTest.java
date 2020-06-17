package tests.apiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static helpers.ParametersProvider.getProperty;
import static helpers.RestAssuredHelper.getValueFromJson;

public class GetInformationAboutDiskTest extends ApiBaseTest {

    public GetInformationAboutDiskTest() throws IOException {
    }

    @Description("Ac01  - Получение информации о диске")
    @Test
    public void getInformationAboutDiskTest() throws IOException {
        response = apiMethods.getInformationAboutDisk();
        Assert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        Assert.assertEquals(
                getValueFromJson(response, "user.login").toLowerCase(),
                getProperty("user"),
                "Логин не соответствует ожидаемому значению.");
    }

    @Description("Ac02 - Получение информации о диске без авторизации")
    @Test
    public void getInformationAboutDiskWithoutAuthTest() {
        response = apiMethods.getInformationAboutDisk("");
        Assert.assertEquals(response.getStatusCode(), 401,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }

    @Description("Ac03 - Получение информации о диске с неверным или истекшим токеном")
    @Test
    public void getInformationAboutDiskWithBrokenTokenTest() {
        response = apiMethods.getInformationAboutDisk("brokenToken");
        Assert.assertEquals(response.getStatusCode(), 401,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }
}

package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class PublishFileTest extends ApiBaseTest {

    public PublishFileTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
    }

    @Description("Ac17 - Публикация файла")
    @Test
    public void publishResourcesTest() {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.publishResources(workPath + workFile);
        softAssert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        softAssert.assertNotEquals(getValueFromJson(response, "public_url"), "",
                "Файл не был опубликован.");
        softAssert.assertAll();
    }
}

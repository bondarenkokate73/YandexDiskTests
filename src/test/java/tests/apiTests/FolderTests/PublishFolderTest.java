package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class PublishFolderTest extends ApiBaseTest {

    public PublishFolderTest() throws IOException {
    }

    @BeforeMethod
    public void createFolderIfNotExist() {
        response = apiMethods.getInformationAboutFolder(workFolder);
        if (response.getStatusCode() != 200) {
            apiMethods.createFolder(workFolder);
        }
    }

    @Description("Ac24 - Публикация папки")
    @Test
    public void publishResourcesTest() {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.publishResources(workFolder);
        softAssert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFolder(workFolder);
        softAssert.assertNotEquals(getValueFromJson(response, "public_url"), "",
                "Файл не был опубликован.");
        softAssert.assertAll();
    }
}

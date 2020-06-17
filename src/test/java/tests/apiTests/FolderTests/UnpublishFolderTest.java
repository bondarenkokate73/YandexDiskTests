package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class UnpublishFolderTest extends ApiBaseTest {


    public UnpublishFolderTest() throws IOException {
    }

    @BeforeMethod
    public void createFolderIfNotExist() {
        response = apiMethods.getInformationAboutFolder(workFolder);
        if (response.getStatusCode() == 404) {
            apiMethods.createFolder(workFolder);
        }
        apiMethods.publishResources(workFolder);
    }

    @Description("Ac18 - Снятие папки с публикации")
    @Test
    public void unpublishFileTest() {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.unpublishResources(workFolder);
        softAssert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFolder(workFolder);
        softAssert.assertEquals(getValueFromJson(response, "public_url"), null,
                "Папка не была снята с публикации.");
        softAssert.assertAll();
    }
}

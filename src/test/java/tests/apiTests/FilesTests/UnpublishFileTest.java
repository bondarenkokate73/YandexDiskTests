package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class UnpublishFileTest extends ApiBaseTest {


    public UnpublishFileTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
        apiMethods.publishResources(workPath + workFile);
    }

    @Description("Ac18 - Снятие файла с публикации")
    @Test
    public void unpublishFileTest() {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.unpublishResources(workPath + workFile);
        softAssert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        softAssert.assertEquals(getValueFromJson(response, "public_url"), null,
                "Файл не был снят с публикации.");
        softAssert.assertAll();
    }
}

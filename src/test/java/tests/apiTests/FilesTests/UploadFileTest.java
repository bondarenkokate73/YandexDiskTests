package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class UploadFileTest extends ApiBaseTest {

    public UploadFileTest() throws IOException {
    }

    @BeforeMethod
    public void deleteFileIfExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() != 404) {
            apiMethods.deleteFile(workPath, workFile);
        }
    }

    @Description("Ac20 - Загрузка нового файла в диск")
    @Test
    public void uploadFileTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        Thread.sleep(1000);
        softAssert.assertEquals(response.getStatusCode(), 202,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        softAssert.assertEquals(getValueFromJson(response, "name"),
                workFile,
                "Файл не был загружен.");
        softAssert.assertAll();
    }
}

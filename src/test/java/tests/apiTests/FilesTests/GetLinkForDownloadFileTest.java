package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class GetLinkForDownloadFileTest extends ApiBaseTest {

    public GetLinkForDownloadFileTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
        apiMethods.publishResources(workPath + workFile);
    }

    @Description("Ac15 - Получение ссылки на скачивание файла")
    @Test
    public void getLinkForDownloadFileTest() {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.getLinkForDownload(workPath, workFile);
        softAssert.assertEquals(response.getStatusCode(),
                200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        softAssert.assertNotEquals(
                getValueFromJson(response, "public_url"), "",
                "Ссылки получено не было.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteFile() {
        apiMethods.deleteFile(workPath, workFile);
    }
}

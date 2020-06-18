package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class DeleteFileTest extends ApiBaseTest {

    public DeleteFileTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() throws InterruptedException {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
        Thread.sleep(1000);
    }

    @Description("Ac12 - Удаление файла")
    @Test
    public void deleteFileTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.deleteFile(workPath, workFile);
        Thread.sleep(1000);
        softAssert.assertEquals(response.getStatusCode(),
                204,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        softAssert.assertEquals(
                response.getStatusCode(),
                404,
                "Файл не был удален.");
        softAssert.assertAll();
    }
}

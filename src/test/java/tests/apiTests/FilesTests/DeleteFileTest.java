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
    public void uploadFileIfNotExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
    }

    @Description("Ac12 - Удаление файла")
    @Test
    public void deleteFileTest() {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.deleteFile(workPath, workFile);
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

package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class CopyFileTest extends ApiBaseTest {

    public CopyFileTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
    }

    @Description("Ac14 - Копирование файла")
    @Test
    public void copyFileTest() {
        SoftAssert softAssert = new SoftAssert();
        response = apiMethods.copyFile(workPath, workPath, workFile);
        softAssert.assertEquals(response.getStatusCode(),
                201,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFile(workPath, "Copy-" + workFile);
        softAssert.assertEquals(response.getStatusCode(), 200,
                "Скопированного файла найдено не было.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void deleteFiles() {
        apiMethods.deleteFile(workPath, workFile);
        apiMethods.deleteFile(workPath, "Copy-" + workFile);
    }
}

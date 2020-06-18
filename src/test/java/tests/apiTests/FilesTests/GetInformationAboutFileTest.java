package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class GetInformationAboutFileTest extends ApiBaseTest {

    public GetInformationAboutFileTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() throws InterruptedException {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
        Thread.sleep(1000);
    }

    @Description("Ac04 - Получение информации о файле")
    @Test
    public void getInformationAboutFileTest() {
        final String nameFile = workFile;
        response = apiMethods
                .getInformationAboutFile(workPath, nameFile);
        Assert.assertEquals(
                response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        Assert.assertEquals(nameFile,
                getValueFromJson(response, "name"),
                "Получена некорректная информация.");
    }

    @Description("Ac05 - Получение информации о несуществующем файле")
    @Test
    public void getInformationAboutNotExistsFileTest() {
        final String nameFile = "АбсолютноНесуществующийФайл.пнг";
        response = apiMethods
                .getInformationAboutFile(workPath, nameFile);
        Assert.assertEquals(
                response.getStatusCode(), 404,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }

    @AfterMethod
    public void deleteFile() {
        apiMethods.deleteFile("/", workFile);
    }
}

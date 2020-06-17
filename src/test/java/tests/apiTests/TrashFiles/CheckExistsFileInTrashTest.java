package tests.apiTests.TrashFiles;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class CheckExistsFileInTrashTest extends ApiBaseTest {
    public CheckExistsFileInTrashTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
        apiMethods.deleteFile(workPath, workFile);
    }

    @Description("Ac22 - Проверка наличия файла в корзине")
    @Test
    public void checkExistsFileInTrashTest() {
        response = apiMethods.checkExistsFileInTrash(workFile);
        Assert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }
}

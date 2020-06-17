package tests.apiTests.TrashFiles;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class RecoveryFileFromTrashTest extends ApiBaseTest {
    public RecoveryFileFromTrashTest() throws IOException {
    }

    @BeforeMethod
    public void uploadFileIfNotExists() {
        response = apiMethods.getInformationAboutFile(workPath, workFile);
        if (response.getStatusCode() == 404) {
            apiMethods.uploadFile(workPath, workFile, linkUploadFile);
        }
        apiMethods.deleteFile(workPath, workFile);
    }

    @Description("Ac23 - Восстановление файла из корзины")
    @Test
    public void recoveryFileFromTrashTest() {
        response = apiMethods.recoveryFileFromTrash(workFile);
        Assert.assertEquals(response.getStatusCode(), 201,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }
}

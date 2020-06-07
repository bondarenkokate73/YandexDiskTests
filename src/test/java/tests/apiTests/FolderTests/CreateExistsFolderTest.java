package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

public class CreateExistsFolderTest extends ApiBaseTest {

    String folder = "ApiTestFolder";

    @BeforeMethod
    public void createFolderIfNotExist() {
        response = apiMethods.getInformationAboutFolder(folder);
        if (response.getStatusCode() != 200) {
            apiMethods.createFolder(folder);
        }
    }

    @Description("Ac09 - Создание уже существующей папки")
    @Test
    public void createExistsFolderTest() {
        response = apiMethods
                .createFolder(folder);
        Assert.assertEquals(response.getStatusCode(), 409,
                "Запрос вернул код " + response.getStatusCode());
    }

    @AfterMethod
    public void deleteFolder() {
        apiMethods.deleteFolder(folder);
    }
}

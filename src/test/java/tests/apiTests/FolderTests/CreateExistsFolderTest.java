package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class CreateExistsFolderTest extends ApiBaseTest {

    public CreateExistsFolderTest() throws IOException {
    }

    @BeforeMethod
    public void createFolderIfNotExist() {
        response = apiMethods.getInformationAboutFolder(workFolder);
        if (response.getStatusCode() != 200) {
            apiMethods.createFolder(workFolder);
        }
    }

    @Description("Ac09 - Создание уже существующей папки")
    @Test
    public void createExistsFolderTest() {
        response = apiMethods
                .createFolder(workFolder);
        Assert.assertEquals(response.getStatusCode(), 409,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }

    @AfterMethod
    public void deleteFolder() {
        apiMethods.deleteFolder(workFolder);
    }
}

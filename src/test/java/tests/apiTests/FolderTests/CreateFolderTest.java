package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import static helpers.RestAssuredHelper.getValueFromJson;

public class CreateFolderTest extends ApiBaseTest {

    String folder = "ApiTestFolder";

    @BeforeMethod
    public void deleteFolderIfExist() {
        response = apiMethods.getInformationAboutFolder(folder);
        if (response.getStatusCode() == 200) {
            apiMethods.deleteFolder(folder);
        }
    }

    @Description("Ac08 - Создание папки")
    @Test
    public void createFolderTest() {
        response = apiMethods.createFolder(folder);
        Assert.assertEquals(response.getStatusCode(), 201,
                "Запрос вернул код " + response.getStatusCode());
        response = apiMethods.getInformationAboutFolder(folder);
        Assert.assertEquals(folder, getValueFromJson(response, "name"),
                "Получена некорректная информация.");
    }

    @AfterMethod
    public void deleteFolder() {
        apiMethods.deleteFolder(folder);
    }
}

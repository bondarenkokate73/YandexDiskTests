package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

import static helpers.RestAssuredHelper.getValueFromJson;

public class CreateFolderTest extends ApiBaseTest {

    public CreateFolderTest() throws IOException {
    }

    @BeforeMethod
    public void deleteFolderIfExist() {
        response = apiMethods.getInformationAboutFolder(workFolder);
        if (response.getStatusCode() == 200) {
            apiMethods.deleteFolder(workFolder);
        }
    }

    @Description("Ac08 - Создание папки")
    @Test
    public void createFolderTest() {
        response = apiMethods.createFolder(workFolder);
        Assert.assertEquals(response.getStatusCode(), 201,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
        response = apiMethods.getInformationAboutFolder(workFolder);
        Assert.assertEquals(workFolder, getValueFromJson(response, "name"),
                "Получена некорректная информация.");
    }

    @AfterMethod
    public void deleteFolder() {
        apiMethods.deleteFolder(workFolder);
    }
}

package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

public class DeleteFolderTest extends ApiBaseTest {

    String folder = "ApiTestFolder";

    @BeforeMethod
    public void createFolderIfNotExist()
    {
        response = apiMethods.getInformationAboutFolder(folder);
        if (response.getStatusCode() != 200) {
            apiMethods.createFolder(folder);
        }
    }

    @Description("Ac10 - Удаление папки")
    @Test
    public void deleteFolderTest() {
        response = apiMethods
                .deleteFolder(folder);
        Assert.assertEquals(response.getStatusCode(), 204,
                "Запрос вернул код " + response.getStatusCode());
    }
}

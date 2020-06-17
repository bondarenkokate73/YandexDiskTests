package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class DeleteFolderTest extends ApiBaseTest {

    public DeleteFolderTest() throws IOException {
    }

    @BeforeMethod
    public void createFolderIfNotExist() {
        response = apiMethods.getInformationAboutFolder(workFolder);
        if (response.getStatusCode() != 200) {
            apiMethods.createFolder(workFolder);
        }
    }

    @Description("Ac10 - Удаление папки")
    @Test
    public void deleteFolderTest() {
        response = apiMethods
                .deleteFolder(workFolder);
        Assert.assertEquals(response.getStatusCode(), 204,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }
}

package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

public class DeleteNotExistFolderTest extends ApiBaseTest {

    String folder = "ApiTestFolder";

    @BeforeMethod
    public void deleteFolderIfExist() {
        response = apiMethods.getInformationAboutFolder(folder);
        if (response.getStatusCode() == 200) {
            apiMethods.deleteFolder(folder);
        }
    }

    @Description("Ac11 - Удаление несуществующей папки")
    @Test
    public void deleteNotExistsFolderTest() {
        folder = "ТочноНесуществующаяПапка";
        response = apiMethods
                .deleteFolder(folder);
        Assert.assertEquals(response.getStatusCode(), 404,
                "Запрос вернул код " + response.getStatusCode());
    }
}

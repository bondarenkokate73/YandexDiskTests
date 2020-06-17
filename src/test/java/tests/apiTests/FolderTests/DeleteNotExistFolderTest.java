package tests.apiTests.FolderTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class DeleteNotExistFolderTest extends ApiBaseTest {

    public DeleteNotExistFolderTest() throws IOException {
    }

    @BeforeMethod
    public void deleteFolderIfExist() {
        response = apiMethods.getInformationAboutFolder(workFolder);
        if (response.getStatusCode() == 200) {
            apiMethods.deleteFolder(workFolder);
        }
    }

    @Description("Ac11 - Удаление несуществующей папки")
    @Test
    public void deleteNotExistsFolderTest() {
        workFolder = "ТочноНесуществующаяПапка";
        response = apiMethods
                .deleteFolder(workFolder);
        Assert.assertEquals(response.getStatusCode(), 404,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }
}

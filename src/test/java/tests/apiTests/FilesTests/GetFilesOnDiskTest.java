package tests.apiTests.FilesTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class GetFilesOnDiskTest extends ApiBaseTest {

    public GetFilesOnDiskTest() throws IOException {
    }

    @Description("Ac16 - Получение списка файлов с диска")
    @Test
    public void getFilesOnDisk() {
        response = apiMethods.getFilesOnDisk();
        Assert.assertEquals(response.getStatusCode(), 200,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }
}

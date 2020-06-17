package tests.apiTests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class GetListPublicResourcesTest extends ApiBaseTest {
    public GetListPublicResourcesTest() throws IOException {
    }

    @Description("Ac19 - Получение списка опубликованных ресурсов")
    @Test
    public void getListPublicResourcesTest() {
        response = apiMethods.getListPublicResources();
        Assert.assertEquals(response.getStatusCode(), 200,
                "Списка файлов получено не было.");
    }
}

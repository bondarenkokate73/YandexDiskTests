package tests.apiTests.TrashFiles;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.apiTests.ApiBaseTest;

import java.io.IOException;

public class CleanTrashTest extends ApiBaseTest {
    public CleanTrashTest() throws IOException {
    }

    @Description("Ac21 - Очистка корзины")
    @Test
    public void cleanTrashTest() {
        response = apiMethods.cleanTrash();
        Assert.assertEquals(response.getStatusCode(), 202,
                "Запрос вернул код " + response.getStatusCode() + response.asString());
    }
}

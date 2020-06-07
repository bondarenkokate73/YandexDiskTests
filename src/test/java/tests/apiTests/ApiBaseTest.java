package tests.apiTests;

import api.ApiMethods;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static helpers.ParametersProvider.getProperty;

public class ApiBaseTest {

    public static final class EndPoints {

        public static final String BASE_PATH = "https://cloud-api.yandex.net:443/v1/disk";

        public static final String RESOURCES = "/resources?path={path}";

        public static final String COPY = "/copy?from={from}&path={path}";

        public static final String DOWNLOAD = "/download?path={path}";

        public static final String FILES = "/files";

        public static final String PUBLISH = "/publish?path={path}";

        public static final String UNPUBLISH = "/unpublish?path={path}";

        public static final String PUBLIC = "/public";

        public static final String UPLOAD = "/upload?path={path}&url={url}";
    }

    private static String authToken;

    public Response response;

    public ApiMethods apiMethods;

    public String folder = "ApiTestFolder";

    public static String getToken() {
        return authToken;
    }

    @Description("Получение токена")
    @BeforeMethod
    public void getAuthToken() throws IOException {
        authToken = getProperty("authToken");
        apiMethods = new ApiMethods();
    }
}

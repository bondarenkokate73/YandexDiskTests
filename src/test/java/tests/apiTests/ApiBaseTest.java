package tests.apiTests;

import api.ApiMethods;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import static helpers.ParametersProvider.getProperty;

public class ApiBaseTest {

    public ApiBaseTest() throws IOException {
    }

    public static final class EndPoints {

        public static final String BASE_PATH = "https://cloud-api.yandex.net:443/v1/disk";

        public static final String RESOURCES = "/resources?path={path}";

        public static final String COPY = "/resources/copy?from={from}&path={path}";

        public static final String DOWNLOAD = "/resources/download?path={path}";

        public static final String FILES = "/resources/files";

        public static final String PUBLISH = "/resources/publish?path={path}";

        public static final String UNPUBLISH = "/resources/unpublish?path={path}";

        public static final String PUBLIC = "/resources/public";

        public static final String UPLOAD = "/resources/upload?path={path}&url={url}";

        public static final String TRASH = "/trash/resources";

        public static final String IN_TRASH = "/?path={path}";

        public static final String RESTORE = "/restore?path={path}";
    }

    private static String authToken;

    public Response response;

    public ApiMethods apiMethods;

    public String workPath = "/";

    public String workFolder = "ApiTestFolder";

    public String workFile = "s1200.jpg";

    public String linkUploadFile = getProperty("fileForUpload");

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

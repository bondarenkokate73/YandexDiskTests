package helpers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tests.apiTests.ApiBaseTest;

public class RestAssuredHelper {

    private RequestSpecification request;

    private TypesOfRequest type;

    /**
     * Виды запросов.
     */
    public enum TypesOfRequest {
        PUT,
        POST,
        GET,
        DELETE
    }

    public RestAssuredHelper(final TypesOfRequest typesOfRequest) {
        this.type = typesOfRequest;
    }

    @Step("Задание заголовков запроса без авторизации")
    public final RestAssuredHelper setRequestSpecification() {
        request = RestAssured
                .given()
                .contentType(ContentType.JSON);
        return this;
    }

    @Step("Задание заголовков запроса с авторизацией")
    public final RestAssuredHelper setRequestSpecification(final String token) {
        request = RestAssured
                .given()
                .header("Authorization", token)
                .contentType(ContentType.JSON);
        return this;
    }

    @Step("Отправка запроса на сервер")
    public final Response makeRequest(final String path) {
        String requestPath = ApiBaseTest.EndPoints.BASE_PATH + path;
        Response response;
        switch (type) {
            case GET:
                response = request.get(requestPath);
                break;
            case PUT:
                response = request.put(requestPath);
                break;
            case POST:
                response = request.post(requestPath);
                break;
            case DELETE:
                response = request.delete(requestPath);
                break;
            default:
                throw new IllegalStateException("Unexpected value: "
                        + type);
        }
        return response;
    }

    @Step("Получение значения атрибута из ответа от сервера")
    public static String getValueFromJson(final Response response,
                                          final String nameAttribute) {
        String responseStr = response.asString();
        return JsonPath.from(responseStr).get(nameAttribute);
    }
}

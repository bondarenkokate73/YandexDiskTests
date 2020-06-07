package helpers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import tests.apiTests.ApiBaseTest;

public class RestAssuredHelper {

    /**
     * Спецификация запроса.
     */
    private RequestSpecification request;

    /**
     * Вид запроса.
     */
    private TypesOfRequest type;

    /**
     * Виды запросов.
     */
    public enum TypesOfRequest {
        /**
         *
         */
        PUT,
        /**
         *
         */
        POST,
        /**
         *
         */
        GET,
        /**
         *
         */
        DELETE
    }

    /**
     * @param typesOfRequest вид запроса
     */
    public RestAssuredHelper(final TypesOfRequest typesOfRequest) {
        this.type = typesOfRequest;
    }

    /**
     * Запись нужных параметров запроса.
     *
     * @return RestAssuredHelper
     */
    public final RestAssuredHelper setRequestSpecification() {
        request = RestAssured
                .given()
                .contentType(ContentType.JSON);
        return this;
    }

    /**
     * Запись нужных параметров запроса.
     *
     * @return RestAssuredHelper
     */
    public final RestAssuredHelper setRequestSpecification(final String token) {
        request = RestAssured
                .given()
                .header("Authorization", token)
                .contentType(ContentType.JSON);
        return this;
    }

    /**
     * Отправка запроса.
     *
     * @param path путь для запроса
     * @return ответ
     */
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

    /**
     * Получение нужного значения из ответа на запрос.
     *
     * @param response      Ответ сервера
     * @param nameAttribute Название атрибута
     * @return значение атрибута
     */
    public static String getValueFromJson(final Response response,
                                          final String nameAttribute) {
        String responseStr = response.asString();
        return JsonPath.from(responseStr).get(nameAttribute);
    }
}

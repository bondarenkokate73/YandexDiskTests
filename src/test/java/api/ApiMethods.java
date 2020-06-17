package api;

import helpers.RestAssuredHelper;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static helpers.RestAssuredHelper.TypesOfRequest.*;
import static tests.apiTests.ApiBaseTest.EndPoints.*;
import static tests.apiTests.ApiBaseTest.getToken;

public class ApiMethods {

    @Step("Полученин информации о диске")
    public Response getInformationAboutDisk() {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest("");
    }

    @Step("Получение информации о диске с недействительным токеном")
    public Response getInformationAboutDisk(final String brokenToken) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(brokenToken)
                .makeRequest("");
    }

    @Step("Получение информации о папке")
    public Response getInformationAboutFolder(final String path) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}", path));
    }

    @Step("Получение информации о файле")
    public Response getInformationAboutFile(final String path,
                                            final String nameFile) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}", path + nameFile));
    }

    @Step("Создание папки")
    public Response createFolder(final String path) {
        return new RestAssuredHelper(PUT)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}", path));
    }

    @Step("Удаление папки")
    public Response deleteFolder(final String path) {
        return new RestAssuredHelper(DELETE)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}", path));
    }

    @Step("Загрузка файлов на диск")
    public Response uploadFile(final String path,
                               final String name,
                               final String url) {
        return new RestAssuredHelper(POST)
                .setRequestSpecification(getToken())
                .makeRequest(UPLOAD
                        .replace("{path}", path + name)
                        .replace("{url}", url));
    }

    @Step("Удаление файла")
    public Response deleteFile(final String path,
                               final String name) {
        return new RestAssuredHelper(DELETE)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}", path + name));
    }

    @Step("Копирование файла")
    public Response copyFile(final String from,
                             final String path,
                             final String name) {
        return new RestAssuredHelper(POST)
                .setRequestSpecification(getToken())
                .makeRequest(COPY
                        .replace("{from}", from + name)
                        .replace("{path}", path + "Copy-" + name));
    }

    @Step("Получение ссылки на скачивание файла")
    public Response getLinkForDownload(final String path,
                                       final String name) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(DOWNLOAD
                        .replace("{path}", path + name));
    }

    @Step("Получение списка файлов на диске")
    public Response getFilesOnDisk() {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(FILES);
    }

    @Step("Публикация ресурсов")
    public Response publishResources(final String path) {
        return new RestAssuredHelper(PUT)
                .setRequestSpecification(getToken())
                .makeRequest(PUBLISH
                        .replace("{path}", path));
    }

    @Step("Снятие с публикации ресурса")
    public Response unpublishResources(final String path) {
        return new RestAssuredHelper(PUT)
                .setRequestSpecification(getToken())
                .makeRequest(UNPUBLISH
                        .replace("{path}", path));
    }

    @Step("Получение списка опубликованных файлов")
    public Response getListPublicResources() {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(PUBLIC);
    }

    @Step("Очистка корзины")
    public Response cleanTrash() {
        return new RestAssuredHelper(DELETE)
                .setRequestSpecification(getToken())
                .makeRequest(TRASH);
    }

    @Step("Проверка наличия файла в корзине")
    public Response checkExistsFileInTrash(final String file) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(TRASH + IN_TRASH.replace("{path}", file));
    }

    @Step("Восстановление файла из корзины")
    public Response recoveryFileFromTrash(final String file) {
        return new RestAssuredHelper(PUT)
                .setRequestSpecification(getToken())
                .makeRequest(TRASH + RESTORE.replace("{path}", file));
    }
}

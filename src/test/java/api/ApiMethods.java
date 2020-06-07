package api;

import helpers.RestAssuredHelper;
import io.restassured.response.Response;
import tests.apiTests.ApiBaseTest;

import static helpers.RestAssuredHelper.TypesOfRequest.*;
import static tests.apiTests.ApiBaseTest.EndPoints.RESOURCES;
import static tests.apiTests.ApiBaseTest.getToken;

public class ApiMethods {

    public Response getInformationAboutDisk() {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest("");
    }

    public Response getInformationAboutDisk(final String brokenToken) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(brokenToken)
                .makeRequest("");
    }

    public Response getInformationAboutFolder(final String path) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}",
                                path));
    }

    public Response getInformationAboutFile(final String path,
                                            final String nameFile) {
        return new RestAssuredHelper(GET)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}",
                                path + nameFile));
    }

    public Response createFolder(final String path) {
        return new RestAssuredHelper(PUT)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}",
                                path));
    }

    public Response deleteFolder(final String path) {
        return new RestAssuredHelper(DELETE)
                .setRequestSpecification(getToken())
                .makeRequest(RESOURCES
                        .replace("{path}",
                                path));
    }
}

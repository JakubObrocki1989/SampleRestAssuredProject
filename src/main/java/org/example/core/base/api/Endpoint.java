package org.example.core.base.api;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.example.core.config.Configuration;
import org.example.core.models.api.responses.BaseResponse;
import org.example.core.models.config.Environment;


import java.util.List;

import static io.restassured.RestAssured.given;

public abstract class Endpoint<T extends BaseResponse> {
    private static final Environment environment = Configuration.getEnvironment();
    private String endpoint;
    protected final RequestSpecification requestSpecification;
    private final Class<T> responseModel;
    protected ValidatableResponse response;

    public Endpoint() {
        responseModel = null;
        requestSpecification = getRequestSpecification();
    }

    public Endpoint(String name) {
        endpoint = name;
        responseModel = null;
        requestSpecification = getRequestSpecification();
    }

    public Endpoint(Class<T> model, String name) {
//        super();
        endpoint = name;
        responseModel = model;
        requestSpecification = getRequestSpecification();
    }

    private RequestSpecification getRequestSpecification() {
        return given().baseUri(environment.getApiUrl()).relaxedHTTPSValidation().log().all();
    }

    public Endpoint<T> get() {
        response = requestSpecification.when().log().all().get(endpoint).then();
        return this;
    }

    public Endpoint<T> get(String path) {
        response = requestSpecification.when().log().all().get(endpoint + path).then();
        return this;
    }

    public Endpoint<T> post() {
        response = requestSpecification.when().post(endpoint).then();
        return this;
    }

    public Endpoint<T> ok() {
        response.statusCode(HttpStatus.SC_OK);
        return this;
    }

    public Endpoint<T> created() {
        response.statusCode(HttpStatus.SC_CREATED);
        return this;
    }

    public Endpoint<T> badRequest() {
        response.statusCode(HttpStatus.SC_BAD_REQUEST);
        return this;
    }

    public Endpoint<T> notFound() {
        response.statusCode(HttpStatus.SC_NOT_FOUND);
        return this;
    }

    public T result() {
        return response.extract().response().body().as(responseModel);
    }

//    public String resultString() {
//        return response.
//    }

    public List<T> results() {
        return response.extract().body().jsonPath().getList("", responseModel);
    }

    public Endpoint<T> header(String name, String value) {
        requestSpecification.header(name, value);
        return this;
    }
}

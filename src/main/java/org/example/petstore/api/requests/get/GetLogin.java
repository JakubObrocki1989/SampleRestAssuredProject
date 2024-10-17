package org.example.petstore.api.requests.get;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.User;

import static io.restassured.RestAssured.given;

public class GetLogin implements ExecutableRequest<User> {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetLogin(String username, String password, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addQueryParam("username", username);
        this.requestSpecBuilder.addQueryParam("password", password);
    }
    @Override
    @Step("Get request - login")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().get("user/login");
    }


    @Override
    public User saveAsDto() {
        return null;
    }
}

package org.example.petstore.api.requests.get;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.User;

import static io.restassured.RestAssured.given;

public class GetLogout implements ExecutableRequest<User> {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetLogout(String username, String password, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
    }
    @Override
    @Step("Get request - logout")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().get("user/logout");
    }


    @Override
    public User saveAsDto() {
        return null;
    }
}

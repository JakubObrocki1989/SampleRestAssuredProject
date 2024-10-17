package org.example.petstore.api.requests.delete;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.User;

import static io.restassured.RestAssured.given;

public class DeleteUser implements ExecutableRequest<User> {
    private final RequestSpecBuilder requestSpecBuilder;

    public DeleteUser(String username, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("username", username);
    }
    @Override
    @Step("Delete request - user")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().delete("user/{username}");
    }


    @Override
    public User saveAsDto() {
        return null;
    }
}

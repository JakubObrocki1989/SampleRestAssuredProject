package org.example.petstore.api.requests.put;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.User;

import static io.restassured.RestAssured.given;

public class PutUser implements ExecutableRequest<User> {
    private final RequestSpecBuilder requestSpecBuilder;

    public PutUser(String username, User user, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("username", username);
        this.requestSpecBuilder.setBody(user);
    }
    @Override
    @Step("Put request - user")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().put("user/{username}");
    }


    @Override
    public User saveAsDto() {
        return execute().then().extract().as(User.class);
    }
}

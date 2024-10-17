package org.example.petstore.api.requests.post;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostUser implements ExecutableRequest<User> {

    private final RequestSpecBuilder requestSpecBuilder;

    public PostUser(User user, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.setBody(user);
    }
    @Override
    @Step("Post request - user")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().post("user");
    }

    @Override
    public User saveAsDto() {
        return execute().then().extract().as(User.class);
    }

}

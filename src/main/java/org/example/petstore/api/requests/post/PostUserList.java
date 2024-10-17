package org.example.petstore.api.requests.post;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.Order;
import org.example.petstore.api.models.User;
import org.example.petstore.factories.OrderFactory;
import org.example.petstore.factories.UserFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class PostUserList implements ExecutableRequest<User> {

    private final RequestSpecBuilder requestSpecBuilder;

    public PostUserList(List<User> users, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.setBody(users);
    }
    @Override
    @Step("Post request - user list")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().post("user/createWithList");
    }

    @Override
    public User saveAsDto() {
        return null;
    }

    public List<User> saveAllAsDto() {
        return execute().then().extract().jsonPath().getList("", User.class);
    }

}

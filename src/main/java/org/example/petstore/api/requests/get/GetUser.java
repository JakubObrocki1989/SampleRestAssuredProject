package org.example.petstore.api.requests.get;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.User;
import org.example.petstore.api.models.pet.Pet;

import static io.restassured.RestAssured.given;

public class GetUser implements ExecutableRequest<User> {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetUser(String username, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("username", username);
    }
    @Override
    @Step("Get request - user")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().get("user/{username}");
    }


    @Override
    public User saveAsDto() {
        return execute().then().extract().as(User.class);
    }
}

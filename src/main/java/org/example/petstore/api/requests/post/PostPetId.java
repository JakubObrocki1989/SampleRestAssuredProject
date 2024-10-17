package org.example.petstore.api.requests.post;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.pet.Pet;

import static io.restassured.RestAssured.given;

public class PostPetId implements ExecutableRequest<Pet> {


    private final RequestSpecBuilder requestSpecBuilder;

    public PostPetId(String petId, String newName, String newStatus, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType("application/x-www-form-urlencoded");
        this.requestSpecBuilder.addPathParam("petId", petId);
        this.requestSpecBuilder.addFormParam("name", newName);
        this.requestSpecBuilder.addFormParam("status", newStatus);
    }
    @Override
    @Step("Post request - pet id")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().post("pet/{petId}");
    }

    @Override
    public Pet saveAsDto() {
        return null;
    }
}

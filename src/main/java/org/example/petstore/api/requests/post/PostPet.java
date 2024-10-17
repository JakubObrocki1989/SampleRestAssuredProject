package org.example.petstore.api.requests.post;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.pet.Pet;
import org.example.petstore.factories.PetFactory;

import static io.restassured.RestAssured.given;

public class PostPet implements ExecutableRequest<Pet> {

    private final RequestSpecBuilder requestSpecBuilder;


    public PostPet(Pet pet, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.setBody(pet);
    }
    @Override
    @Step("Post request - pet")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().post("pet");
    }

    @Override
    public Pet saveAsDto() {
        return execute().then().extract().as(Pet.class);
    }
}

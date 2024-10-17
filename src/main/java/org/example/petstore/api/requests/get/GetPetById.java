package org.example.petstore.api.requests.get;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.pet.Pet;

import static io.restassured.RestAssured.given;

public class GetPetById implements ExecutableRequest<Pet> {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetPetById(String petId, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("petId", petId);
    }

    @Override
    @Step("Get request - pet by id")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().get("pet/{petId}");
    }


    @Override
    public Pet saveAsDto() {
        return execute().then().extract().as(Pet.class);
    }
}

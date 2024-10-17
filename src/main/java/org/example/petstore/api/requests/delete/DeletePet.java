package org.example.petstore.api.requests.delete;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.response.ApiResponse;

import static io.restassured.RestAssured.given;

public class DeletePet implements ExecutableRequest<ApiResponse> {

    private final RequestSpecBuilder requestSpecBuilder;

    public DeletePet(String petId, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("petId", petId);
    }
    @Override
    @Step("Delete request - pet")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().delete("pet/{petId}");
    }

    @Override
    public ApiResponse saveAsDto() {
        return null;
    }
}

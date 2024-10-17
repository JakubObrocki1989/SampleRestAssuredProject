package org.example.petstore.api.requests.post;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.core.helpers.FileHandler;
import org.example.petstore.api.models.response.ApiResponse;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PostPetImage implements ExecutableRequest<ApiResponse> {
    FileHandler fileHandler = new FileHandler();
    private final RequestSpecBuilder requestSpecBuilder;

    public PostPetImage(String petId, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType("multipart/form-data");
        this.requestSpecBuilder.addPathParam("petId", petId);
        this.requestSpecBuilder.addMultiPart("additionalMetadata", "test");
        this.requestSpecBuilder.addMultiPart("file", new File(fileHandler.getPath("src/test/resources/avatar.png")), "image/png");
    }

    @Override
    @Step("Post request - pet image")
    public Response execute() {
            return given().spec(requestSpecBuilder.build()).when().log().all().post("pet/{petId}/uploadImage");
    }

    @Override
    public ApiResponse saveAsDto() {
        return null;
    }
}

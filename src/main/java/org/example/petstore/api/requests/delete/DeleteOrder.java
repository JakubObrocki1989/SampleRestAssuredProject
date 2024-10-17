package org.example.petstore.api.requests.delete;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.Order;

import static io.restassured.RestAssured.given;

public class DeleteOrder implements ExecutableRequest<Order> {
    private final RequestSpecBuilder requestSpecBuilder;

    public DeleteOrder(String petId, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("orderId", petId);
    }

    @Override
    @Step("Delete request - order")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().delete("store/order/{orderId}");
    }

    @Override
    public Order saveAsDto() {
        return null;
    }
}

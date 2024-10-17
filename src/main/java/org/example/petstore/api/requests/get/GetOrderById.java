package org.example.petstore.api.requests.get;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.Order;
import org.example.petstore.api.models.pet.Pet;

import static io.restassured.RestAssured.given;

public class GetOrderById implements ExecutableRequest<Order> {
    private final RequestSpecBuilder requestSpecBuilder;

    public GetOrderById(String petId, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.addPathParam("orderId", petId);
    }

    @Override
    @Step("Get request - order by id")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().get("store/order/{orderId}");
    }

    @Override
    public Order saveAsDto() {
        return execute().then().extract().as(Order.class);
    }
}

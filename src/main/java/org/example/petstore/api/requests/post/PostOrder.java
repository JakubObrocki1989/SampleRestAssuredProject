package org.example.petstore.api.requests.post;

import io.qameta.allure.Step;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.core.api.ExecutableRequest;
import org.example.petstore.api.models.Order;
import org.example.petstore.api.models.pet.Pet;
import org.example.petstore.factories.OrderFactory;

import static io.restassured.RestAssured.given;

public class PostOrder implements ExecutableRequest<Order> {

    private final RequestSpecBuilder requestSpecBuilder;

    OrderFactory orderFactory = new OrderFactory();

    public PostOrder(Order order, RequestSpecBuilder requestSpecBuilder) {
        this.requestSpecBuilder = requestSpecBuilder;
        this.requestSpecBuilder.setContentType(ContentType.JSON);
        this.requestSpecBuilder.setBody(order);
    }
    @Override
    @Step("Post request - order")
    public Response execute() {
        return given().spec(requestSpecBuilder.build()).when().log().all().post("store/order");
    }

    @Override
    public Order saveAsDto() {
        return execute().then().extract().as(Order.class);
    }
}

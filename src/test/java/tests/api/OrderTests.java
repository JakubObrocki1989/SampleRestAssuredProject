package tests.api;

import base.BaseTests;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.example.core.api.ApiClient;
import org.example.petstore.api.models.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderTests extends BaseTests {

    private ApiClient api;

    @BeforeEach
    public void setupClient() {
        api = createApiClient();
    }

    @Test
    public void createOrder() {
        assertThat(api.postOrder(orderFactory.getRandomOrder()).execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void createReadDeleteOrderFlow() {
        Order order = orderFactory.getRandomOrder();
        api.postOrder(order).execute();
        Order orderDto = api.getOrderById(String.valueOf(order.getId())).saveAsDto();
        Assertions.assertThat(order).usingRecursiveComparison().ignoringFields("shipDate").isEqualTo(orderDto);
        assertThat(api.deleteOrder(String.valueOf(orderDto.getId())).execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        assertThat(api.getOrderById(String.valueOf(orderDto.getId())).execute().getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
    }

}

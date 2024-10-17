package base;

import com.github.javafaker.Faker;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.example.core.api.ApiClient;
import org.example.core.config.Configuration;
import org.example.petstore.factories.OrderFactory;
import org.example.petstore.factories.PetFactory;
import org.example.petstore.factories.UserFactory;

public class BaseTests {

    protected Faker faker = new Faker();

    protected UserFactory userFactory = new UserFactory();
    protected PetFactory petFactory = new PetFactory();
    protected OrderFactory orderFactory = new OrderFactory();

    protected ApiClient createApiClient() {
        return new ApiClient(() -> new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .setBaseUri(Configuration.getEnvironment().getApiUrl()));
    }
}

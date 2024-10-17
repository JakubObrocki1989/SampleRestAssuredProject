package tests.api;

import base.BaseTests;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.example.core.api.ApiClient;
import org.example.petstore.api.models.User;
import org.example.petstore.api.models.pet.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class UserTests extends BaseTests {
    private ApiClient api;

    @BeforeEach
    public void setupClient() {
        api = createApiClient();
    }

    @Test
    public void createUser() {
        assertThat(api.postUser(userFactory.getRandomUser()).execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void createReadUpdateDeleteUserFlow() {
        User user = userFactory.getRandomUser();
        api.postUser(user).execute();
        User userDto = api.getUser(user.getUsername()).saveAsDto();
        Assertions.assertThat(user).usingRecursiveComparison().isEqualTo(userDto);
        userDto.setEmail(faker.internet().emailAddress());
        api.putUser(userDto.getUsername(), userDto).execute();
        User updatedUser = api.getUser(userDto.getUsername()).saveAsDto();
        Assertions.assertThat(updatedUser).usingRecursiveComparison().isEqualTo(userDto);
        assertThat(api.deleteUser(updatedUser.getUsername()).execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        assertThat(api.getUser(updatedUser.getUsername()).execute().getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
    }
}

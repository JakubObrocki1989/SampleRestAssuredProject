package tests.api;

import base.BaseTests;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.example.core.api.ApiClient;
import org.example.petstore.api.models.pet.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PetTests extends BaseTests {
    private ApiClient api;

    @BeforeEach
    public void setupClient() {
        api = createApiClient();
    }

    @Test
    public void createPet() {
        assertThat(api.postPet(petFactory.getRandomPet()).execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @Test
    public void createReadUpdateDeletePetFlow() {
        Pet pet = petFactory.getRandomPet();
        Pet petDto = api.postPet(pet).saveAsDto();
        Assertions.assertThat(pet).usingRecursiveComparison().isEqualTo(petDto);
        petDto.setName(faker.name().name());
        Pet updatedPet = api.putPet(petDto).saveAsDto();
        Assertions.assertThat(updatedPet).usingRecursiveComparison().isEqualTo(petDto);
        assertThat(api.deletePet(String.valueOf(updatedPet.getId())).execute().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        assertThat(api.getPetById(String.valueOf(updatedPet.getId())).execute().getStatusCode()).isEqualTo(HttpStatus.SC_NOT_FOUND);
    }
}

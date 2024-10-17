package tests.api;

import base.BaseTests;
import org.example.core.api.ApiClient;
import org.example.petstore.api.models.User;
import org.example.petstore.api.models.response.ApiResponse;
import org.example.petstore.factories.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Tmp extends BaseTests {

    private ApiClient api;

    @BeforeEach
    public void setupClient() {
        api = createApiClient();
    }

    @Test
    public void test() {
//        Order order = api.postOrder().saveAsDto();
//        Order order2 = api.getOrderById(String.valueOf(order.getId())).saveAsDto();
//        ApiResponse response = api.deleteOrder(String.valueOf(order.getId())).execute().then().extract().as(ApiResponse.class);
//        Random random = new Random();
//        List<User> users = new ArrayList<>();
        UserFactory userFactory = new UserFactory();
        User user = userFactory.getRandomUser();
        api.postUser(user).execute();
        User userDto = api.getUser(user.getUsername()).saveAsDto();
        ApiResponse response = api.getLogin(userDto.getUsername(), userDto.getPassword()).execute().then().extract().as(ApiResponse.class);
//        for(int i = 0; i<=random.nextInt(0,10); i++) {
//            users.add(userFactory.getRandomUser());
//        }
//        api.postUserList(users).
//        List<User> users = api.postUserList().saveAsDtoList();
//        List<User> users = new ArrayList<>();
//        users.add(userFactory.getRandomUser());
//        api.postUserList(users).execute();
//        User userDto = api.getUser(users.get(0).getUsername()).saveAsDto();
//        userDto.setFirstName("new name");
//        userDto.setLastName("new lastname");
//        api.putUser(userDto.getUsername(), userDto).execute();
//        User userDto2 = api.getUser(users.get(0).getUsername()).saveAsDto();
//        api.deleteUser(users.get(0).getUsername()).execute();

//        api.postUserList().execute();
//        Pet pet = api.getPetById("1").saveAsDto();
//        PetUploadImage response = api.postPetImage("5354").execute().then().extract().as(PetUploadImage.class);
//        Pet pet = api.postPet().saveAsDto();
//        api.deletePet(String.valueOf(pet.getId())).execute().then().extract().as(ApiResponse.class);
//        ApiResponse pet2 = api.getPetById(String.valueOf(pet.getId())).execute().then().extract().as(ApiResponse.class);
//        Pet pet2 = api.getPetById(String.valueOf(pet.getId())).saveAsDto();
//        api.postPetId(String.valueOf(pet.getId()), "kuba", "mdry").execute().then().extract().as(PetUploadImage.class);

//        List<Pet> pets = api.getPetsByStatus("available").execute().then().extract().response().jsonPath().getList("", Pet.class);
    }
}

package org.example.core.api;

import io.restassured.builder.RequestSpecBuilder;
import org.example.petstore.api.models.Order;
import org.example.petstore.api.models.User;
import org.example.petstore.api.models.pet.Pet;
import org.example.petstore.api.requests.delete.DeleteOrder;
import org.example.petstore.api.requests.delete.DeletePet;
import org.example.petstore.api.requests.delete.DeleteUser;
import org.example.petstore.api.requests.get.*;
import org.example.petstore.api.requests.post.*;
import org.example.petstore.api.requests.put.PutPet;
import org.example.petstore.api.requests.put.PutUser;

import java.util.List;
import java.util.function.Supplier;

public class ApiClient {

    private final Supplier<RequestSpecBuilder>requestSpecBuilderSupplier;

    public ApiClient(Supplier<RequestSpecBuilder> requestSpecBuilderSupplier) {
        this.requestSpecBuilderSupplier = requestSpecBuilderSupplier;
    }

    public GetPetById getPetById(String petId) {
        return new GetPetById(petId, requestSpecBuilderSupplier.get());
    }
    public PostPetImage postPetImage(String petId) {
        return new PostPetImage(petId, requestSpecBuilderSupplier.get());
    }

    public PostPet postPet(Pet pet) {return new PostPet(pet, requestSpecBuilderSupplier.get());}

    public PutPet putPet(Pet pet) { return new PutPet(pet, requestSpecBuilderSupplier.get());}

    public GetPetsByStatus getPetsByStatus(String status) { return new GetPetsByStatus(status, requestSpecBuilderSupplier.get());}

    public PostPetId postPetId(String petId, String newName, String newStatus) { return new PostPetId(petId, newName, newStatus, requestSpecBuilderSupplier.get());}

    public DeletePet deletePet(String petId) { return new DeletePet(petId, requestSpecBuilderSupplier.get());}

    public PostOrder postOrder(Order order) { return new PostOrder(order, requestSpecBuilderSupplier.get());}
    public GetOrderById getOrderById(String orderId) {
        return new GetOrderById(orderId, requestSpecBuilderSupplier.get());
    }

    public DeleteOrder deleteOrder(String orderId) { return new DeleteOrder(orderId, requestSpecBuilderSupplier.get());}
    public PostUserList postUserList(List<User> users) { return new PostUserList(users, requestSpecBuilderSupplier.get());}
    public GetUser getUser(String username) {
        return new GetUser(username, requestSpecBuilderSupplier.get());
    }
    public PutUser putUser(String username, User user) {
        return new PutUser(username, user, requestSpecBuilderSupplier.get());
    }

    public DeleteUser deleteUser(String username) {
        return new DeleteUser(username, requestSpecBuilderSupplier.get());
    }

    public PostUser postUser(User user) {
        return new PostUser(user, requestSpecBuilderSupplier.get());
    }

    public GetLogin getLogin(String username, String password) {
        return new GetLogin(username, password, requestSpecBuilderSupplier.get());
    }
}

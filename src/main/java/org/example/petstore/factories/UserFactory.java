package org.example.petstore.factories;

import org.example.core.base.BaseFactory;
import org.example.petstore.api.models.User;
import org.example.petstore.api.models.pet.Pet;
import org.example.petstore.api.models.pet.PetCategory;
import org.example.petstore.api.models.pet.PetTag;

import java.util.ArrayList;
import java.util.List;

public class UserFactory extends BaseFactory {
    public User getRandomUser() {
        User.UserBuilder user = User.builder();
        user
                .id(faker.number().numberBetween(1, 10000))
                .username(faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .email(faker.internet().emailAddress())
                .password(faker.internet().password())
                .phone(faker.number().digit())
                .userStatus(faker.number().numberBetween(1, 10));
            return user.build();
    }
}

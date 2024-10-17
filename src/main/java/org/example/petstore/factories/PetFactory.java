package org.example.petstore.factories;

import org.example.core.base.BaseFactory;
import org.example.petstore.api.models.pet.Pet;
import org.example.petstore.api.models.pet.PetCategory;
import org.example.petstore.api.models.pet.PetTag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetFactory extends BaseFactory {

    List<String> petStatuses = List.of("available", "pending", "sold");
    public Pet getRandomPet() {
        Pet.PetBuilder pet = Pet.builder();
        pet
                .id(faker.number().numberBetween(100000, 999999))
                .name(faker.name().name())
                .category(new PetCategory(faker.number().numberBetween(0, 100), faker.pokemon().name()))
                .photoUrls(new ArrayList<>())
                .tags(List.of(new PetTag(faker.number().numberBetween(0, 100), faker.starTrek().character())))
                .status(petStatuses.get(rand.nextInt(petStatuses.size())));
        return pet.build();
    }
}

package org.example.core.base;

import com.github.javafaker.Faker;

import java.util.Random;

public abstract class BaseFactory {
    protected Faker faker = new Faker();
    protected Random rand = new Random();
}

package com.magebit.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {

    private static Faker fakerObject = new Faker();

    public static String randomData(String data) {

        String password = fakerObject.internet().password();

        switch (data.toUpperCase()) {
            case "RANDOMFIRSTNAME":
                return fakerObject.name().firstName();
            case "RANDOMLASTNAME":
                return fakerObject.name().lastName();
            case "RANDOMEMAIL":
                return fakerObject.internet().emailAddress();
            case "RANDOMPASSWORD":
                return password;

        }
        return data;
    }
}

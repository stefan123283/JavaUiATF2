package com.magebit.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {

    private static Faker fakerObject = new Faker();

    static String password = null;

    private static String generateRandomPassword() {
        if (password == null) {
            password = fakerObject.internet().password(8, 9, true);
        }
        return password;
    }

    public static String randomData(String data) {

        switch (data.toUpperCase()) {
            case "RANDOMFIRSTNAME":
                return fakerObject.name().firstName();
            case "RANDOMLASTNAME":
                return fakerObject.name().lastName();
            case "RANDOMEMAIL":
                return fakerObject.internet().emailAddress();
            case "RANDOMPASSWORD":
                return generateRandomPassword();
        }
        return data;
    }

}

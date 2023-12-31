package com.magebit.managers;

import com.github.javafaker.Faker;

public class RandomDataManager {

    private static Faker fakerObject = new Faker();

    static String password = null;

    private static String generateRandomPassword() {
        if (password == null) {
            password = fakerObject.internet().password(8, 9, true, true);
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
            case "LEADINGSPACESRANDOMPASSWORD":
                return " " + generateRandomPassword();
            case "TRAILINGSPACESRANDOMPASSWORD":
                return generateRandomPassword() + " ";
            case "RANDOMPHONENUMBER":
                return fakerObject.numerify("0########");
            case "RANDOMSTREETADDRESS":
                return fakerObject.address().streetAddress();
            case "RANDOMCITY":
                return fakerObject.address().city();
            case "RANDOMZIPCODE":
                return fakerObject.address().zipCode();
        }
        return data;
    }

}

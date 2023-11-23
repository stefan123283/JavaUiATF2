package com.magebit.stepdefinitions;

import com.magebit.managers.DriverManager;
import io.cucumber.java.AfterAll;

public class Hooks {

    @AfterAll
    public static void afterAll() {
        DriverManager.getInstance().tearDown();
    }
}

package com.magebit.stepdefinitions;

import com.magebit.managers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import org.apache.logging.log4j.Level;

public class Hooks {

    @After
    public void afterEachTest(){
        DriverManager.getInstance().deleteAllCookies();
    }

    @AfterAll
    public static void afterAll() {
        DriverManager.getInstance().tearDown();
    }
}

package com.magebit;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/magebit/features",
        glue = "com.magebit.stepdefinitions",
        tags = "@Smoke5"
)

public class CucumberTestRunner {
}
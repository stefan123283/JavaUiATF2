package com.magebit.stepdefinitions;

import com.magebit.managers.ConfigReaderManager;
import com.magebit.managers.DriverManager;
import com.magebit.managers.RandomDataManager;
import org.junit.jupiter.api.Assertions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public class CommonSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    @Given("{string} end-part is accessed")
    public void endPartIsAccessed(String endPartValue) {
        driver.get(ConfigReaderManager.getPropertyValue("url") + endPartValue);
    }

    @When("the following form from {string} is populated as follow:")
    public void theFollowingFormFromIsPopulatedAsFollow(String pageName, Map<String, String> fieldAndValueMap) {
        fieldAndValueMap.forEach((fieldName, fieldValue) -> {
            try {
                Class classInstance = Class.forName("com.magebit.pageobjects." + pageName);
                Field classField = classInstance.getDeclaredField(fieldName);
                classField.setAccessible(true);
                WebElement inputElement = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
                fieldValue = RandomDataManager.randomData(fieldValue);
                inputElement.sendKeys(fieldValue);
                System.out.println(fieldName + ":" + fieldValue);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    @And("the {string} from {string} is clicked")
    public void theFromIsClicked(String elementName, String pageName) {
        try {
            Class classInstance = Class.forName("com.magebit.pageobjects." + pageName);
            Field classField = classInstance.getDeclaredField(elementName);
            classField.setAccessible(true);
            WebElement elementToBeClicked = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            elementToBeClicked.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the following list of messages is displayed:")
    public void theFollowingListOfMessagesIsDisplayed(List<String> errorMessagesList) throws InterruptedException {
        Thread.sleep(500);
        errorMessagesList.forEach(confirmationMessage -> {
            boolean confirmationMessageIsDisplayed = driver.findElement(By.xpath("//*[contains(text(),'" + confirmationMessage + "')]")).isDisplayed();
            Assertions.assertTrue(confirmationMessageIsDisplayed, "The " + confirmationMessage + " was not displayed");
        });
    }
}

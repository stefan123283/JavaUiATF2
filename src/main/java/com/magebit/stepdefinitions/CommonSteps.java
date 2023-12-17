package com.magebit.stepdefinitions;

import com.magebit.managers.*;
import com.magebit.pageobjects.Page;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(CommonSteps.class);

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
                ExplicitWaitManager.waitTillTheElementIsClickable(inputElement);
                fieldValue = RandomDataManager.randomData(fieldValue);
                inputElement.clear();
                inputElement.sendKeys(fieldValue);
                logger.log(Level.INFO, fieldName + ":" + fieldValue);

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
            ExplicitWaitManager.waitTillTheElementIsClickable(elementToBeClicked);
            elementToBeClicked.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("the current url contains {string} keyword")
    public void theCurrentUrlContainsKeyword(String keyWordFromTheUrl) throws InterruptedException {
        Thread.sleep(500);
        String currentUrl = driver.getCurrentUrl();
        boolean currentUrlContainsKeyword = currentUrl.contains(keyWordFromTheUrl);

        Assertions.assertTrue(currentUrlContainsKeyword, "The keyword: " + keyWordFromTheUrl + " is present in " + currentUrl);
    }

    @Then("the following list of messages is displayed:")
    public void theFollowingListOfMessagesIsDisplayed(List<String> MessagesList) throws InterruptedException {
        Thread.sleep(500);
        MessagesList.forEach(message -> {
            boolean messageIsDisplayed = driver.findElement(By.xpath("//*[contains(text(),\"" + message + "\")]")).isDisplayed();
            Assertions.assertTrue(messageIsDisplayed, "The error message: " + message + " is displayed");
        });
    }


    @And("the {string} from {string} is selected")
    public void theFromIsSelected(String elementName, String pageName) {

        try {
            Class classInstance = Class.forName("com.magebit.pageobjects." + pageName);
            Field classField = classInstance.getDeclaredField(elementName);
            classField.setAccessible(true);
            WebElement selectElement = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            selectElement.click();
            List<WebElement> selectValues = selectElement.findElements(By.xpath(".//*"));
            WebElement randomValue =  selectValues.get((int)Math.floor(Math.random() * (selectValues.size() + 1) + 0));
            randomValue.click();
            logger.log(Level.INFO, "Country/State: " + randomValue.getText());
        } catch (Exception e) {
            logger.log(Level.INFO, "The country chosen does not have states");
        }
    }

}



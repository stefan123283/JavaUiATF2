package com.magebit.stepdefinitions;

import com.magebit.managers.DriverManager;
import com.magebit.managers.ExplicitWaitManager;
import io.cucumber.java.en.And;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.List;

public class AccountPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();

    private static final Logger logger = LogManager.getLogger(CommonSteps.class);
    @And("the delete button from the address number {int} is clicked")
    public void theAddressIsDeleted(int nrOrderOfTheAddress) {
        try {
            Class classInstance = Class.forName("com.magebit.pageobjects.AccountPage");
            Field classField = classInstance.getDeclaredField("tableOfAddresses");
            classField.setAccessible(true);
            WebElement tableOfAddresses = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            List<WebElement> address = tableOfAddresses.findElements(By.tagName("tr"));
            logger.log(Level.INFO, "The number of addresses from this account is " + address.size());
            WebElement deleteAddressBtn = driver.findElement(By.xpath("//tbody/tr[" + nrOrderOfTheAddress + "]/td[9]/a[2]/span[1]"));
            ExplicitWaitManager.waitTillTheElementIsClickable(deleteAddressBtn);
            deleteAddressBtn.click();
        } catch (Exception e) {
            logger.log(Level.INFO, "The number introduced is too big. Try introducing a number smaller or equal to the number of addresses from this account");
        }
    }

    @And("the edit button from the address number {int} is clicked")
    public void theAddressIsEdited(int nrOrderOfTheAddress) {
        try {
            Class classInstance = Class.forName("com.magebit.pageobjects.AccountPage");
            Field classField = classInstance.getDeclaredField("tableOfAddresses");
            classField.setAccessible(true);
            WebElement tableOfAddresses = (WebElement) classField.get(classInstance.getConstructor(WebDriver.class).newInstance(driver));
            List<WebElement> address = tableOfAddresses.findElements(By.tagName("tr"));
            logger.log(Level.INFO, "The number of addresses from this account is " + address.size());
            WebElement editAddressBtn = driver.findElement(By.xpath("//tbody/tr[" + nrOrderOfTheAddress + "]/td[9]/a[1]/span[1]"));
            ExplicitWaitManager.waitTillTheElementIsClickable(editAddressBtn);
            editAddressBtn.click();
        } catch (Exception e) {
            logger.log(Level.INFO, "The number introduced is too big. Try introducing a number smaller or equal to the number of addresses from this account");
        }
    }
}

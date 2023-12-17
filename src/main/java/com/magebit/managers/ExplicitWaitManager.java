package com.magebit.managers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitManager {

    private static int explicitWaitTime = Integer.parseInt(ConfigReaderManager.getPropertyValue("explicitWaitTime"));

    private static WebDriverWait waitObject = new WebDriverWait(DriverManager.getInstance().getDriver(), Duration.ofSeconds(explicitWaitTime));

    public static void waitTillTheElementIsClickable(WebElement element) {
        waitObject.until(ExpectedConditions.elementToBeClickable(element));
    }

}

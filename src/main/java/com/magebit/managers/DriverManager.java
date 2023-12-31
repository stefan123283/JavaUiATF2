package com.magebit.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
    private static String webDriverType = ConfigReaderManager.getPropertyValue("browserType");
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {
        switch (webDriverType.toUpperCase()) {
            case "CHROME":
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                driver = new FirefoxDriver();
                break;
            case "EDGE":
                EdgeOptions options = new EdgeOptions();
                options.addArguments("user-data-dir=C:\\Users\\Frunza Stefan\\AppData\\Local\\Microsoft\\Edge\\User Data");
                options.addArguments("profile-directory=Profile 3");
                options.addArguments("--start-maximized");
                driver = new EdgeDriver(options);
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
        }

    }

    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    public void tearDown() {
        driver.close();
        driver.quit();
        instance = null;
        driver = null;
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

}
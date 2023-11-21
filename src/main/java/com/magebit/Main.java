package com.magebit;

import com.magebit.managers.DriverManager;
import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://magento2-demo.magebit.com/");
    }
}
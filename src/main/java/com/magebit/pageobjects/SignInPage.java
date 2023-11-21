package com.magebit.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")

    private WebElement emailInput;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")

    private WebElement passwordInput;

    @FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")

    private WebElement signInBtn;

}


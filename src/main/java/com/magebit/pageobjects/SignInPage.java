package com.magebit.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends Page{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[class='action create primary'] span")

    private WebElement createAccountBtn;

    @FindBy(id = "email")

    private WebElement emailInput;

    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass']")

    private WebElement passwordInput;

    @FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")

    private WebElement signInBtn;

}


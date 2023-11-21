package com.magebit.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    public Page(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "div[class='panel header'] li[data-label='or'] a")

    protected WebElement signInLink;

    @FindBy(xpath = "//div[@class='panel header']//a[@id='idpeY80u3Y']")

    protected WebElement createAccountLink;

}


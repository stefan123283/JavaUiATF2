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

    @FindBy(css = "header[class='page-header'] li:nth-child(3) a:nth-child(1)")

    protected WebElement createAccountLink;

}


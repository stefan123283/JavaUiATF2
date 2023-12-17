package com.magebit.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Page{
    public AccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "li:nth-child(7) a:nth-child(1)")

    private WebElement accountInfLink;

    @FindBy(id = "firstname")

    private WebElement firstNameInput;

    @FindBy(id = "lastname")

    private WebElement lastNameInput;

    @FindBy(id = "change-email")

    private WebElement emailCheck;

    @FindBy(id = "change-password")

    private WebElement passwordCheck;

    @FindBy(id = "email")

    private WebElement emailInput;

    @FindBy(id = "current-password")

    private WebElement currentPasswordInput;

    @FindBy(id = "password")

    private WebElement newPasswordInput;

    @FindBy(id = "password-confirmation")

    private WebElement confirmNewPasswordInput;

    @FindBy(css = "button[title='Save'] span")

    private WebElement saveBtn;

    @FindBy(xpath = "//a[normalize-space()='Address Book']")

    private WebElement accountAddressLink;

    @FindBy(xpath = "//span[normalize-space()='Change Billing Address']")

    private WebElement billingAddressLink;

    @FindBy(xpath = "//span[normalize-space()='Change Shipping Address']")

    private WebElement shippingAddressLink;

    @FindBy(xpath = "//span[normalize-space()='Add New Address']")

    private WebElement addNewAddressBtn;

    @FindBy(id = "telephone")

    private WebElement phoneNumInput;

    @FindBy(id = "street_1")

    private WebElement streetAddressInput;

    @FindBy(id = "city")

    private WebElement cityInput;

    @FindBy(id = "region_id")

    private WebElement stateSelectValue;

    @FindBy(id = "zip")

    private WebElement zipCodeInput;

    @FindBy(id = "country")

    private WebElement countrySelectValue;

    @FindBy(css = "button[title='Save Address'] span")

    private WebElement saveAddressBtn;

    @FindBy(xpath = "//span[normalize-space()='OK']")

    private WebElement addressDeleteConfirmationBtn;

    @FindBy(xpath = "//*[@id=\"additional-addresses-table\"]/tbody")

    private WebElement tableOfAddresses;


}


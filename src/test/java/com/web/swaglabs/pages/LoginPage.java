package com.web.swaglabs.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//span[@data-test='title']")
    private WebElement productsTxt;

    @FindBy(xpath = "//h3 [@data-test='error']")
    private WebElement errorWrongUsernamePassowrdTxt;


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void enterUsername(String name) {
        waitUtils.waitForVisibility(userNameField).sendKeys(name);

    }

    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passwordField).sendKeys(password);
    }


    public void clickLogin() {
        waitUtils.waitForClickableAndClick(loginButton);
    }


    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getProductsTitle() {
        return waitUtils.waitForVisibility(productsTxt).getText();
    }

    public String getErrorUsernameAndPassowrd(){
        return waitUtils.waitForVisibility(errorWrongUsernamePassowrdTxt).getText();
    }

}

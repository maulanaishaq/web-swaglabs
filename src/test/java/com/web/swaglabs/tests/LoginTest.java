package com.web.swaglabs.tests;

import com.web.swaglabs.base.BaseTest;
import com.web.swaglabs.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest  {


   // @Test(groups = "regression", dependsOnMethods = "failedLoginTest", enabled = false)
    @Test
    public void successLoginTest()  {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getProductsTitle(), "Products");
    }

    @Test(groups = {"sanity","login"})
    public void failedLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("test","test");
        String actual = loginPage.getErrorUsernameAndPassowrd();
        String expected = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(expected, actual);
    }



    @Test(dataProvider = "loginCredentials", dataProviderClass = TestData.class)
    public void successLoginWithTestDatObjectArray(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getProductsTitle(), "Products");

    }

    /*
    @Test(dataProvider = "loginFromExcel", dataProviderClass = TestData.class)
    public void successLoginWithTestDataExcel(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Assert.assertEquals(loginPage.getProductsTitle(), "Products");

    }

    */



}

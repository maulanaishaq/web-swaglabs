package com.web.swaglabs.pages;


import com.web.swaglabs.utils.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {


    protected WebDriver driver;
    protected WaitUtils waitUtils;


    public BasePage(WebDriver driver){
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }




}

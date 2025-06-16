package com.web.swaglabs.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.web.swaglabs.utils.DriverFactory;
import com.web.swaglabs.utils.ExtentManager;
import com.web.swaglabs.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import com.web.swaglabs.utils.ConfigReader;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;


public class BaseTest {

    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupReporting() {
        extent = ExtentManager.createInstance();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, Method method) {
        ConfigReader.initProperties();
        driver = DriverFactory.initDriver(ConfigReader.getProperty("browser"));
        driver.get(ConfigReader.getProperty("baseUrl"));

        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getName());
            test.fail(result.getThrowable());
            test.addScreenCaptureFromPath(screenshotPath);

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");

        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test skipped");
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReport() {
        extent.flush();
    }

}

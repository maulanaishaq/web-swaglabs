package com.web.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver initDriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver(getChromeOptions(false));
                break;
            case "chrome-headless":
                driver = new ChromeDriver(getChromeOptions(true));
                break;
            case "firefox":
                driver = new FirefoxDriver(getFirefoxOptions(false));
                break;
            case "firefox-headless":
                driver = new FirefoxDriver(getFirefoxOptions(true));
                break;
            case "edge":
                driver = new EdgeDriver(getEdgeOptions(false));
                break;
            case "edge-headless":
                driver = new EdgeDriver(getEdgeOptions(true));
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }


    private static ChromeOptions getChromeOptions(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        return options;
    }

    private static FirefoxOptions getFirefoxOptions(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("--headless");
        }
        return options;
    }

    private static EdgeOptions getEdgeOptions(boolean headless) {
        EdgeOptions options = new EdgeOptions();
        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }
        return options;
    }


}

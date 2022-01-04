package com.automationpractice.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    protected static ChromeDriver chromeDriver;

    public static WebDriver getChromeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("window-size=1920,1080");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--ignore-certificate-errors");

        if (headless) {
            options.addArguments("--disable-web-security");
            options.addArguments("--no-sandbox");
            options.addArguments("--verbose");
            options.setHeadless(true);
        }

        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver(options);
        }
        return chromeDriver;
    }

    public static void tearDownDriver() {
        chromeDriver.quit();
        chromeDriver = null;
    }
}

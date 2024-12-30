package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UserAgentTest {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        
        // Initialize ChromeDriver instance with options
        WebDriver driver = new ChromeDriver(options);
        
        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Launch URL
            driver.get("https://www.seleniumhq.org/download/");
            
            // Get user agent using JavaScript execution
            String userAgent = (String) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return navigator.userAgent");
            
            // Print user agent
            System.out.println("User agent:");
            System.out.println(userAgent);
        } finally {
            // Close browser session
            driver.quit();
        }
    }
}

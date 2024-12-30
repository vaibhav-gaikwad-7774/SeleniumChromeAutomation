package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumExample {
    public static void main(String[] args) {
        // Set the path to chromedriver.exe
        System.setProperty("webdriver.chrome.driver", "D://gfg329//Driver//chromedriver.exe");

        // Initialize ChromeOptions to customize browser settings
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // Start browser maximized

        // Create a new instance of ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Perform any required actions or validations here

        } catch (Exception e) {
            e.printStackTrace(); // Print any exceptions that occur
        } finally {
            // Ensure the browser closes after execution
            driver.quit();
        }
    }
}

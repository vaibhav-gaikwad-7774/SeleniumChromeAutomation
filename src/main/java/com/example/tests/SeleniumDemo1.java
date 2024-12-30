package com.example.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumDemo1 {
    public static void main(String[] args) {
        // Automatically manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions instance
        ChromeOptions options = new ChromeOptions();

        // Set various options
        options.addArguments("--headless"); // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU hardware acceleration
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-notifications"); // Disable notifications
        options.addArguments("start-maximized"); // Start maximized

        // Initialize WebDriver with options
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to a web page
            driver.get("https://geeksforgeeks.org");

            // Output the title of the page
            System.out.println("Page title is: " + driver.getTitle());

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

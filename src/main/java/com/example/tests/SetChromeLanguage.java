package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetChromeLanguage {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Choose the desired language (modify the code for other languages)
        String languageCode = "fr"; // French

        // Configure ChromeOptions to set the language
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=" + languageCode);

        // Initialize ChromeDriver with configured options
        WebDriver driver = new ChromeDriver(options);

        // Print a message indicating the chosen language
        System.out.println("Chrome language set to: " + languageCode);

        // Step 4: Navigate to a website to verify the language setting
        driver.get("https://www.google.com");

        // Step 5: Print the page title (optional)
        String pageTitle = driver.getTitle();
        System.out.println("Page title is: " + pageTitle);

        // Step 6: Close the browser session
        driver.quit();
    }
}
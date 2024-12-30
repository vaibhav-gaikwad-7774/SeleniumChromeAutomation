package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverTest1 {
    public static void main(String[] args) {
        try {
            // Set up ChromeDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            // Initialize ChromeOptions to configure browser settings
            ChromeOptions options = new ChromeOptions();

            // Add the argument for incognito mode
            options.addArguments("--incognito");

            // Initialize ChromeDriver instance with options
            WebDriver driver = new ChromeDriver(options);

            // Maximize the browser window
            driver.manage().window().maximize();

            // Open a website to verify the incognito mode
            driver.get("https://www.google.com");

            // Pause the execution for 5 seconds to see the process
            Thread.sleep(100000);

            // Add any additional test steps here

            // Close the browser
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

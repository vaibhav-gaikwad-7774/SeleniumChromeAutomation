package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RefreshPageExample {
    public static void main(String[] args) {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            // Navigate to a URL
            driver.get("https://www.google.com");
            
            // Print the title of the current page
            System.out.println("Initial page title: " + driver.getTitle());
            
            // Refresh the page
            driver.navigate().refresh();
            
            // Print the title of the refreshed page
            System.out.println("Page title after refresh: " + driver.getTitle());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

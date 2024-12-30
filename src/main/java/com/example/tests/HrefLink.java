package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class HrefLink {
    public static void main(String[] args) {
        // Use WebDriverManager to handle ChromeDriver setup
        WebDriverManager.chromedriver().setup();
        
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait before interacting with elements
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        // Navigate to the target webpage
        driver.get("https://www.geeksforgeeks.org/trending/");
        
        try {
            // Identify the element using link text
            WebElement linkElement = driver.findElement(By.linkText("Trending Now"));
            
            // Get href value from the link
            String hrefValue = linkElement.getAttribute("href");
            System.out.println("Href value of link: " + hrefValue);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser and clean up resources
            driver.quit();
        }
    }
}

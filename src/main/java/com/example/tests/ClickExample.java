package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickExample {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Locate the Google search box
            WebElement searchBox = driver.findElement(By.name("q"));

            // Type a query in the search box
            searchBox.sendKeys("Selenium WebDriver click() example");

            // Locate the Google Search button
            WebElement searchButton = driver.findElement(By.name("btnK"));

            // Pause briefly to ensure the search button is interactable
            Thread.sleep(1000);  // Sleep for 1 second

            // Use click() method to submit the search
            searchButton.click();

            // Pause to observe the results
            Thread.sleep(3000);  // Sleep for 3 seconds

            System.out.println("Search completed using click().");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

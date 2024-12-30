package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScriptTimeoutExample {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Set script timeout
        driver.manage().timeouts().setScriptTimeout(15, java.util.concurrent.TimeUnit.SECONDS);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open Google
        driver.get("https://www.google.com");

        // Perform actions or execute scripts
        // For example, find the search box and enter a query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        // Find the search button and click
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        // Print success message to console
        System.out.println("Script timeout successfully set and operations automated!");

        // Close the browser
        driver.quit();
    }
}

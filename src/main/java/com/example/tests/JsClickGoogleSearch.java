package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JsClickGoogleSearch {
    public static void main(String[] args) {
        try {
            // Set up ChromeDriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            // Initialize ChromeDriver instance
            WebDriver driver = new ChromeDriver();

            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to Google
            driver.get("https://www.google.com/");

            // Slow down to observe loading
            Thread.sleep(2000);

            // Identify the search box element
            WebElement searchBox = driver.findElement(By.name("q"));

            // Enter a search query
            searchBox.sendKeys("Selenium WebDriver");

            // Slow down to observe typing
            Thread.sleep(2000);

            // Identify the "Google Search" button
            WebElement searchButton = driver.findElement(By.name("btnK"));

            // Slow down before clicking the button
            Thread.sleep(2000);

            // Use JavaScriptExecutor to click the "Google Search" button
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", searchButton);

            // Slow down to observe the search results page
            Thread.sleep(3000);

            // Close the browser
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

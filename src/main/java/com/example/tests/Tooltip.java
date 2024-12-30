package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tooltip {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google.com
        driver.get("https://www.google.com");

        // Find the Google Apps icon element (9-dot grid) and extract its tooltip
        WebElement googleAppsIcon = driver.findElement(By.cssSelector("a[aria-label='Google apps']"));

        // Get the tooltip text from the "aria-label" attribute
        String tooltipText = googleAppsIcon.getAttribute("aria-label");

        // Print the tooltip text to the console
        System.out.println("Tooltip text: " + tooltipText);

        // Add a short wait to observe the result (optional)
        Thread.sleep(2000);

        // Close the browser
        driver.quit();
    }
}

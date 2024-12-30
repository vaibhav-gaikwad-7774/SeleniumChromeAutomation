package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysAlternate {
    public static void main(String[] args) {
        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Set implicit wait
        

        try {
            // Navigate to Google
            driver.get("https://www.google.com/");

            // Locate the Google search box using class name
            WebElement searchBox = driver.findElement(By.className("gLFyf"));

            // Use JavaScript Executor to enter text into the search box
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value = 'geeksforgeeks';", searchBox);

            // Pause to observe the text entry
            Thread.sleep(2000);  // Sleep for 2 seconds

            // Retrieve and print the text entered in the search box
            String enteredText = searchBox.getAttribute("value");
            System.out.println("Text entered: " + enteredText);

            // Pause to observe before closing
            Thread.sleep(2000);  // Sleep for 2 seconds

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

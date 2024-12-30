package com.example.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AsyncScriptDemo {
    public static void main(String[] args) throws IOException {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver (ChromeDriver)
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://example.com");

        // Take screenshot before AJAX content loads
        takeScreenshot(driver, "before_content_load.png");

        // Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute async JavaScript
        Object result = js.executeAsyncScript(
            "var callback = arguments[arguments.length - 1];" +
            "setTimeout(function() {" +
            "    callback('AJAX content loaded');" +
            "}, 3000);"
        );

        // Wait for AJAX response (3 seconds)
        System.out.println(result);  // Prints 'AJAX content loaded'

        // Take screenshot after AJAX content loads
        takeScreenshot(driver, "after_content_load.png");

        // Close the browser
        driver.quit();
    }

    // Method to take and save screenshots
    public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
        // Convert WebDriver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture the screenshot and store it as a file
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination where the screenshot will be saved
        File destination = new File(fileName);

        // Copy the screenshot to the destination file
        FileHandler.copy(source, destination);

        System.out.println("Screenshot saved: " + fileName);
    }
}

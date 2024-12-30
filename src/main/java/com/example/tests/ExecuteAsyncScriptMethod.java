package com.example.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExecuteAsyncScriptMethod {
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open the GeeksforGeeks website
        driver.get("https://www.geeksforgeeks.org");

        // Get current system time
        long startTime = System.currentTimeMillis();

        // Create an instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Execute async script to set timeout
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 800);");

        // Print elapsed time
        System.out.println("Time Elapsed is: " + (System.currentTimeMillis() - startTime) + " milliseconds");

        // Close the browser
        driver.quit();
    }
}

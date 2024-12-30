package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysExample {
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
        try {
            // Launch the Google homepage
            driver.get("https://www.google.com/");

            // Slow down to observe the page loading
            Thread.sleep(2000); // Wait for 2 seconds

            // Identify the search box element
            WebElement searchBox = driver.findElement(By.name("q"));

            // Slow down to observe the search box before entering text
            Thread.sleep(2000); // Wait for 2 seconds

            // Use JavaScript Executor to enter text into the search box
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.getElementsByName('q')[0].value= 'geeksforgeeks.org'");

            // Slow down to observe the entered text
            Thread.sleep(2000); // Wait for 2 seconds

            // Retrieve the entered text to verify
            String enteredText = searchBox.getAttribute("value");
            System.out.println("Text entered: " + enteredText);

            // Slow down before closing the browser
            Thread.sleep(2000); // Wait for 2 seconds

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
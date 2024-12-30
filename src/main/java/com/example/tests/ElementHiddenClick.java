package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementHiddenClick {
    public static void main(String[] args) {
        try {
            // Setting up WebDriverManager to manage ChromeDriver
            WebDriverManager.chromedriver().setup();

            // Creating WebDriver instance
            WebDriver driver = new ChromeDriver();

            // Navigating to the web page
            driver.get("https://learn.letskodeit.com/p/practice");

            // Adding a delay to ensure the page is fully loaded
            Thread.sleep(3000);

            // Clicking the "Hide" button to hide the edit box
            driver.findElement(By.id("hide-textbox")).click();

            // Adding a delay to ensure the element is hidden
            Thread.sleep(2000);

            // Initializing JavaScript Executor
            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Setting the value in the hidden element using JavaScript
            js.executeScript("document.getElementById('displayed-text').value='QA';");

            // Retrieving the value from the hidden element
            String str = (String) js.executeScript("return document.getElementById('displayed-text').value");

            // Printing the value entered into the hidden element
            System.out.println("Value entered in hidden element: " + str);

            // Closing the browser
            driver.close();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

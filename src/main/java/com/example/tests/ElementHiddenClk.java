package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementHiddenClk {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Launch the URL
        driver.get("https://www.letskodeit.com/practice");

        // Identify the button and click to hide the textbox
        driver.findElement(By.id("show-textbox")).click();

        // JavascriptExecutor class with executeScript method
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Set value in the hidden element
        js.executeScript("document.getElementById('displayed-text').value='QA Geeksforgeeks';");

        // Retrieve and print the value from the hidden element
        String str = (String) js.executeScript("return document.getElementById('displayed-text').value");
        System.out.println("Value entered in hidden element: " + str);

        // Close the browser
        driver.close();
    }
}

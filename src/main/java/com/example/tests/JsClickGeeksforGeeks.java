package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsClickGeeksforGeeks {
	public static void main(String[] args) {
        // Initialize the Firefox WebDriver
	 WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();
        driver.get("https://www.geeksforgeeks.org/");
        
        // Identify the element using a CSS selector
        WebElement articlesLink = driver.findElement(By.cssSelector("a[href='/articles/']"));
        
        // Click with JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", articlesLink);
        
        // Close the browser
        driver.quit();
     }
  }


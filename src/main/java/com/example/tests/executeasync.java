package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class executeasync {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new FirefoxDriver();
        
        // Apply page load timeout (1 millisecond)
        driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MILLISECONDS);
        
        // Try to load the GeeksforGeeks website
        for (int i = 0; i < 2; i++) {
           try {
              // Try to load the page
              driver.get("https://www.geeksforgeeks.org/");
              break;
           } catch (org.openqa.selenium.TimeoutException e) {
              // Stop the page load using JavaScript
              ((JavascriptExecutor)driver).executeScript("window.stop();");
              System.out.println("Page load took too long, stopping it now.");
           }
        }
        
        // Close the browser
        driver.quit();
     }
  }
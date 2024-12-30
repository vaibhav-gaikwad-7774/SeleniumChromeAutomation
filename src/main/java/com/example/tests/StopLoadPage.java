package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StopLoadPage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Stop page load using JavaScript
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.stop();");

            // Pause execution to allow the page to partially load
            Thread.sleep(2000);  // Sleep for 2 seconds

            // Locate the Google search box
            WebElement searchBox = driver.findElement(By.name("q"));
            System.out.println("Google search box found: " + searchBox.getAttribute("title"));

            // Now navigate to Gmail
            driver.navigate().to("https://www.gmail.com");

            // Stop page load for Gmail
            js.executeScript("window.stop();");

            // Pause execution to allow the page to partially load
            Thread.sleep(2000);  // Sleep for 2 seconds

            // Locate an element on the Gmail page (e.g., the "Email or phone" input box)
            WebElement emailInputBox = driver.findElement(By.id("identifierId"));
            System.out.println("Gmail input box found: " + emailInputBox.getAttribute("aria-label"));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class FrameSwitchingExample {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Open a webpage with an iframe
            driver.get("https://www.example.com/page-with-iframe");

            // Switch to the iframe by its name or ID
            driver.switchTo().frame("frameNameOrID");

            // Perform actions within the iframe
            WebElement frameElement = driver.findElement(By.id("elementInsideIframe"));
            System.out.println("Text inside iframe: " + frameElement.getText());

            // Switch back to the default content
            driver.switchTo().defaultContent();

            // Perform actions in the default content
            WebElement defaultElement = driver.findElement(By.id("elementOutsideIframe"));
            System.out.println("Text outside iframe: " + defaultElement.getText());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}


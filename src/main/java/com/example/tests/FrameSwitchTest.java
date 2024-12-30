package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitchTest {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // URL launch
        driver.get("https://www.w3schools.com/html/html_iframe.asp");

        // Switch to the iframe by its ID
        driver.switchTo().frame("iframeResult");

        // Identify the element inside the iframe
        WebElement iframeText = driver.findElement(By.tagName("h1"));
        System.out.println("Text inside iframe: " + iframeText.getText());

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Identify an element outside the iframe
        WebElement pageTitle = driver.findElement(By.tagName("h1"));
        System.out.println("Text outside iframe: " + pageTitle.getText());

        // Close the browser
        driver.quit();
    }
}

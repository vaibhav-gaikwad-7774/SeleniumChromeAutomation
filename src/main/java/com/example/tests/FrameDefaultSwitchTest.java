package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class FrameDefaultSwitchTest {
    public static void main(String[] args) {
        // Set up FirefoxDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Initialize FirefoxDriver instance
        WebDriver driver = new FirefoxDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // URL launch
        driver.get("http://www.uitestpractice.com/Students/Switchto");

        // Switch to the frame using its name or ID
        driver.switchTo().frame("iframe_a");

        // Identify the element inside the frame
        WebElement frameElement = driver.findElement(By.tagName("h1"));
        System.out.println("Text inside frame: " + frameElement.getText());

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Identify the element outside the frame
        WebElement defaultElement = driver.findElement(By.tagName("h3"));
        System.out.println("Text outside frame: " + defaultElement.getText());

        // Close the browser
        driver.quit();
    }
}

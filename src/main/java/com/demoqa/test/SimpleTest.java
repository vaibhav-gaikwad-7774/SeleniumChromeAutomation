package com.demoqa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SimpleTest {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create an instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to a sample website
        driver.get("https://demoqa.com");

        // Locate an element and print its text
        WebElement heading = driver.findElement(By.tagName("h1"));
        System.out.println("Page Heading: " + heading.getText());

        // Close the browser
        driver.quit();
    }
}

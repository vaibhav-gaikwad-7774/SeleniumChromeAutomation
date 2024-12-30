package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class ImplicitWaitExample {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Set implicit wait time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open Google
        driver.get("https://www.google.com");

        // Find the search box element
        WebElement searchBox = driver.findElement(By.name("q"));

        // Perform actions with the element
        searchBox.sendKeys("Selenium WebDriver");

        // Find the search button and click
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.click();

        // Print success message to console
        System.out.println("Implicit wait successfully automated!");

        // Close the browser
        driver.quit();
    }
}

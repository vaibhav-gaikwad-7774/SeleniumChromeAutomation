package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class DatePickerExample {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Open the website with the Datepicker
            driver.get("https://www.globalsqa.com/demo-site/datepicker/");

            // Switch to the iframe containing the Datepicker
            driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

            // Initialize WebDriverWait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the Datepicker element is visible and click it
            WebElement datepicker = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("datepicker"))
            );
            datepicker.click();
            System.out.println("Datepicker opened");

            // Select a specific date, e.g., 27th of the current month
            WebElement dateToSelect = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='27']"))
            );
            dateToSelect.click();
            System.out.println("Date '27' selected");
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}

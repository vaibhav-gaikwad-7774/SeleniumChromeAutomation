package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class ClickableElement {
    public static void main(String[] args) {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Dynamic Controls page
            driver.get("http://the-internet.herokuapp.com/dynamic_controls");

            // Create a WebDriverWait instance with Duration
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Timeout in seconds

            // Define the locator for the "Enable" button
            By enableButtonLocator = By.xpath("//button[text()='Enable']");

            try {
                // Wait until the "Enable" button is clickable
                WebElement enableButton = wait.until(ExpectedConditions.elementToBeClickable(enableButtonLocator));

                // Click the "Enable" button
                enableButton.click();

                // If we reached this point, the button was clickable and clicked
                System.out.println("The 'Enable' button was clickable and has been clicked.");
                
                // Optionally, wait for the text box to become enabled
                By textBoxLocator = By.id("input-example");
                WebElement textBox = wait.until(ExpectedConditions.elementToBeClickable(textBoxLocator));
                System.out.println("The text box is now enabled.");
                
            } catch (Exception e) {
                // Handle the case where the button is not clickable
                System.out.println("The 'Enable' button is not clickable or an error occurred.");
            }

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}



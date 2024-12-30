package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyErrorMessage {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Navigate to the GFG login page
            driver.get("https://auth.geeksforgeeks.org/");

            // Locate the username and password fields
            WebElement usernameField = driver.findElement(By.id("luser"));
            WebElement passwordField = driver.findElement(By.id("password"));

            // Enter invalid credentials
            usernameField.sendKeys("invalid_username");
            passwordField.sendKeys("invalid_password");
            passwordField.submit();

            // Introduce a small delay to allow the error message to load
            Thread.sleep(3000);

            // Capture the error message
            WebElement errorMessage = driver.findElement(By.cssSelector(".alert.alert-danger"));
            String actualMessage = errorMessage.getText();

            // Verify the error message
            String expectedMessage = "Invalid email or password.";
            if (actualMessage.equals(expectedMessage)) {
                System.out.println("Test Passed: Error message verified successfully.");
            } else {
                System.out.println("Test Failed: Expected message '" + expectedMessage + "', but got '" + actualMessage + "'.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}

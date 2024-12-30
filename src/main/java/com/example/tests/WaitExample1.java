package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class WaitExample1 {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the SauceDemo homepage
            driver.get("https://www.saucedemo.com");
            
            // Wait for the username field to be visible
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            // Pause to observe the process
            Thread.sleep(2000); // Sleep for 2 seconds
            usernameField.sendKeys("standard_user");

            // Wait for the password field to be visible
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            // Pause to observe the process
            Thread.sleep(2000); // Sleep for 2 seconds
            passwordField.sendKeys("secret_sauce");

            // Wait for the login button to be clickable
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            // Pause to observe the process
            Thread.sleep(2000); // Sleep for 2 seconds
            loginButton.click();

            // Wait for the products title to be visible
            WebElement productsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
            // Check if the products title is visible
            if (productsTitle.isDisplayed()) {
                System.out.println("Login was successful and 'Products' page is visible.");
            } else {
                System.out.println("Login failed or 'Products' page is not visible.");
            }
        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted: " + e.getMessage());
        } finally {
            // Ensure the browser is closed
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

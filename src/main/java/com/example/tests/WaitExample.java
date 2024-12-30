package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class WaitExample {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Navigate to the SauceDemo homepage
            driver.get("https://www.saucedemo.com");
            
            // Pause to observe the process
            Thread.sleep(2000); // Sleep for 2 seconds

            // Wait for and interact with the username field
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
            usernameField.sendKeys("standard_user");

            // Pause to observe the typing
            Thread.sleep(2000); // Sleep for 2 seconds

            // Wait for and interact with the password field
            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
            passwordField.sendKeys("secret_sauce");

            // Pause to observe the typing
            Thread.sleep(2000); // Sleep for 2 seconds

            // Wait for and click the login button
            WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
            loginButton.click();

            // Pause to observe the click
            Thread.sleep(2000); // Sleep for 2 seconds

            // Wait for and verify the presence of the products title
            WebElement productsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
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

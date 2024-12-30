package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KeepSessionAlive {
    public static void main(String[] args) {
        // Set up WebDriver using WebDriverManager to handle ChromeDriver setup
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the GitHub login page
            driver.get("https://github.com/login");

            // Log in to the website
            WebElement usernameField = driver.findElement(By.name("login"));
            WebElement passwordField = driver.findElement(By.name("password"));

            usernameField.sendKeys("your_email_or_username"); // Replace with actual username
            passwordField.sendKeys("your_password"); // Replace with actual password
            passwordField.submit();

            // Wait for the login process to complete
            Thread.sleep(5000); // Adjust the sleep time as needed

            // Proceed with the session-keeping mechanism
            keepSessionAlive(driver);

            // Perform your long-running task
            for (int i = 0; i < 10; i++) { // Example of a long-running task
                // Interact with the website (e.g., accessing a specific page)
                driver.get("https://github.com/some-data-page?page=" + i); // Replace with actual data URL
                Thread.sleep(2000); // Simulate processing time
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the session properly
            driver.quit();
        }
    }

    // Implementing a Session-Keeping Mechanism
    public static void keepSessionAlive(WebDriver driver) {
        // Use a separate thread to keep the session alive
        Thread sessionKeeper = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(300000); // Refresh every 5 minutes (adjust as needed)
                    driver.navigate().refresh();
                    System.out.println("Session refreshed to keep it alive.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        sessionKeeper.setDaemon(true); // Set as a daemon thread so it ends with the main thread
        sessionKeeper.start();
    }
}

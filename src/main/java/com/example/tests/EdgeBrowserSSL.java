// Importing necessary packages
package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class EdgeBrowserSSL {

    public static void main(String[] args) {
        // Automatically set up EdgeDriver using WebDriverManager
        WebDriverManager.edgedriver().setup();

        // Create instance of EdgeOptions to manage browser settings
        EdgeOptions options = new EdgeOptions();

        // Configure the browser to accept insecure certificates
        options.setAcceptInsecureCerts(true);

        // Initialize EdgeDriver with the configured EdgeOptions
        WebDriver driver = new EdgeDriver(options);

        // Set implicit wait for WebDriver
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Open the application with SSL certificate issues
        driver.get("https://www.geeksforgeeks.org/");

        // Print the title of the webpage to verify successful access
        System.out.println("Page Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}

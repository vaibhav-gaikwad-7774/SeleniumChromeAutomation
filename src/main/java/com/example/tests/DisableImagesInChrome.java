package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DisableImagesInChrome {
    public static void main(String[] args) {
        // Set up ChromeOptions to disable images
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");

        // Disable images directly using setExperimentalOption
        options.setExperimentalOption("prefs", 
            new java.util.HashMap<String, Object>() {{
                put("profile.managed_default_content_settings.images", 2); // Disable images
        }});

        // Set up WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to GeeksforGeeks website 
            driver.get("https://geeksforgeeks.org");

            // Print message in console confirming images are disabled
            System.out.println("Images disabled successfully!");

            // Pause to see the process
            Thread.sleep(5000);  // Sleep for 5 seconds to observe the process
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the pause
            driver.quit();
        }
    }
}

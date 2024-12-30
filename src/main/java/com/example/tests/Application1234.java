package com.example.tests;
import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Application1234 {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Automatically setup the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        try {
            // Open the main page
            driver.get("https://www.geeksforgeeks.org");

            // Find the first link with the specific class and click it
            WebElement firstLink = driver.findElements(By.className("HomePageCourseCard_homePageCourseCard_textContainer___928L")).get(0);
            firstLink.click();

            // Store the main window handle
            String mainWindowHandle = driver.getWindowHandle();

            // Get all window handles
            Set<String> allWindowHandles = driver.getWindowHandles();

            // Switch to the new window
            for (String handle : allWindowHandles) {
                if (!handle.equals(mainWindowHandle)) {
                    driver.switchTo().window(handle);
                    break;
                }
            }

            // Now the focus is on the new tab/popup
            System.out.println("New tab title: " + driver.getTitle());

            // Switch back to the main window (if needed)
            driver.switchTo().window(mainWindowHandle);
            Thread.sleep(5000);

        } finally {
            // Close the driver
            driver.quit();
        }
    }
}

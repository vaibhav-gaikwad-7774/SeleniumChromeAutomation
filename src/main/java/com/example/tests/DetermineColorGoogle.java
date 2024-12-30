package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DetermineColorGoogle {
    public static void main(String[] args) {

        // Set up WebDriverManager to handle the driver setup automatically
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the Google homepage
            driver.get("https://www.google.com/");

            // Find the "Google Search" button element on the webpage
            WebElement searchButton = driver.findElement(By.name("btnK"));

            // Use getCssValue() method to determine its background color
            String bgColor = searchButton.getCssValue("background-color");

            // Print the background color of the "Google Search" button
            System.out.println("---Background Color of 'Google Search' Button--- " + bgColor);

            // Find the "I'm Feeling Lucky" button element on the webpage
            WebElement luckyButton = driver.findElement(By.name("btnI"));

            // Use getCssValue() method to determine its text color
            String textColor = luckyButton.getCssValue("color");

            // Print the text color of the "I'm Feeling Lucky" button
            System.out.println("---Text Color of 'I'm Feeling Lucky' Button--- " + textColor);

            // Print a success message
            System.out.println("Color values determined successfully!");
            
        } catch(Exception e) {
            // Print any exception that occurs during execution
            e.printStackTrace();
        } finally {
            // Close the browser after the script completes
            driver.quit();
        }
    }
}

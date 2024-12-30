package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DetermineColorExample {
    public static void main(String[] args) {

        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the specified URL
            driver.get("https://www.yatra.com/");

            // Find the "Check Your Refund" button element on the webpage
            WebElement ele = driver.findElement(By.xpath("//input[@value='Check Your Refund']"));

            // Use getCssValue() method to determine its background color
            String bgColor = ele.getCssValue("background-color");

            // Print the background color of the "Check Your Refund" button on the console
            System.out.println("---Background Color--- " + bgColor);

            // Find the "One Way" button element on the webpage
            ele = driver.findElement(By.xpath("//a[@title='One Way']"));

            // Use getCssValue() method to determine its border color
            String borderColor = ele.getCssValue("border-color");

            // Print the border color of the "One Way" button on the console
            System.out.println("---Border Color--- " + borderColor);

            // Use getCssValue() method to determine its text color
            String textColor = ele.getCssValue("color");

            // Print the text color of the "One Way" button on the console
            System.out.println("---Text Color--- " + textColor);

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

package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextTagExample {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to GeeksforGeeks homepage
            driver.get("https://www.geeksforgeeks.org/");

            // Locate the main heading (e.g., an <h1> or <h2> tag)
            WebElement element = driver.findElement(By.xpath("//h2"));

            // Get the text of the element
            String text = element.getText();

            // Print the text
            System.out.println("Text of the heading: " + text);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

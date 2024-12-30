package com.example.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager

public class GeeksForGeeks {
    public static void main(String[] args) {
        // Setup EdgeDriver using WebDriverManager
        WebDriverManager.edgedriver().setup();
        
        // Instantiate an EdgeDriver class
        WebDriver driver = new EdgeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Launch Website
        driver.get("https://www.geeksforgeeks.org/");
        
        // Scroll down to the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
        
        // Optional: Close the driver
        driver.quit();
    }
}

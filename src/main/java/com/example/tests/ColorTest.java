package com.example.tests;

import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ColorTest {
    public static void main(String[] args) {
        // Setup WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Start the Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open the URL
        driver.get("http://blazedemo.com");
        WebElement element = driver.findElement(
            By.xpath("/html/body/div[3]/form/div/input"));

        // Get the background color of the element
        String backgroundColor = element.getCssValue("background-color");
        System.out.println(backgroundColor); // Output: rgba(0,109,204,1)

        // Close the browser
        driver.quit();
    }
}

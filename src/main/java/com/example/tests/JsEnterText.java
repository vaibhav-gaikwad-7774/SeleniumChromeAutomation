package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class JsEnterText {
    public static void main(String[] args) {
        try {
            // Setup WebDriverManager for ChromeDriver
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            
            // URL launch
            driver.get("https://www.geeksforgeeks.org/");
            
            // Add a sleep to slow down for visual observation
            Thread.sleep(2000); // Wait for 2 seconds

            // Explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
            // JavaScript Executor to enter text
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement textBox = driver.findElement(By.className("HomePageSearchContainer_homePageSearchContainer_container_input__1LS0r"));

            // Add sleep before entering text
            Thread.sleep(2000); // Wait for 2 seconds

            // Enter text using JavaScript
            js.executeScript("arguments[0].value='Selenium';", textBox);
            
            // Add sleep after entering text to observe the result
            Thread.sleep(2000); // Wait for 2 seconds
            
            // Verify value
            String value = textBox.getAttribute("value");
            System.out.println("Value entered is: " + value);
            
            // Add sleep before quitting
            Thread.sleep(2000); // Wait for 2 seconds

            // Cleanup
            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

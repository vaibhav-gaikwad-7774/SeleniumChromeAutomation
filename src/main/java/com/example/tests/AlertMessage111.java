package com.example.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class AlertMessage111 {
    public static void main(String[] args) throws Exception {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup(); 
        WebDriver driver = new ChromeDriver();
        
        try {
            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            
            // Launch the URL
            driver.get("https://demoqa.com/alerts");
            Thread.sleep(1000);
            
            // Click on the button to trigger a simple alert
            WebElement alertButton = driver.findElement(By.id("alertButton"));
            alertButton.click();
            Thread.sleep(1000);
            
            // Switch focus to alert
            Alert alert = driver.switchTo().alert();
            
            // Get alert text
            String alertText = alert.getText();
            System.out.println("Alert text is: " + alertText);
            
            // Accepting the alert
            alert.accept();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

package com.example.tests;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
    public static void main(String[] args) throws Exception {
        // Automatically manage the ChromeDriver setup with WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the page
        driver.get("https://globbertrot.github.io/alertpage/");

        // Check if alert is present
        if (isAlertPresent(driver)) {
            System.out.println("Alert present");
        } else {
            System.out.println("No alert present");
        }

        // Close the browser
        driver.quit();
    }

    // Method to check if an alert is present
    public static boolean isAlertPresent(WebDriver driver) {
        try {
            // Try to switch to the alert
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            // If no alert is present, return false
            return false;
        }
    }
}

package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class ChromeDriverTest12 {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the webpage you want to test
            driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

            // Find all checkbox elements on the page using a CSS selector
            List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));

            // Get the total number of checkboxes found on the page
            int totalCheckboxes = checkboxes.size();
            System.out.println("Total number of checkboxes on the page: " + totalCheckboxes);
        } finally {
            // Close the browser after the script completes
            driver.quit();
        }
    }
}

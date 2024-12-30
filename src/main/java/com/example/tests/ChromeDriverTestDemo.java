package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;

public class ChromeDriverTestDemo {
    public static void main(String[] args) throws InterruptedException {
        // Step 1: Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Step 2: Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Step 3: Maximize the browser window
        driver.manage().window().maximize();

        // Step 4: Set an implicit wait of 0.5 seconds
        driver.manage().timeouts().implicitlyWait(500, java.util.concurrent.TimeUnit.MILLISECONDS);

        // Step 5: Launch the URL for Google
        driver.get("https://www.google.com/");

        // Step 6: Identify the search input elements using its name attribute
        List<WebElement> searchBoxes = driver.findElements(By.name("q"));

        // Step 7: Ensure there's at least one search box found
        if (!searchBoxes.isEmpty()) {
            // Step 8: Select the first element in the list and perform actions
            WebElement searchBox = searchBoxes.get(0);
            searchBox.click(); // Correct way to interact with a single element

            // Step 9: Enter 'Selenium' into the search box
            searchBox.sendKeys("Selenium");

            // Step 10: Retrieve the value entered in the search box and print it
            String enteredValue = searchBox.getAttribute("value");
            System.out.println("Value entered: " + enteredValue);
        } else {
            System.out.println("No search box found on the page.");
        }

        // Step 11: Close the browser
        driver.quit();
    }
}

package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class RadioButtonCountArtOfTesting {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open the web page
            driver.get("https://artoftesting.com/samplesiteforselenium");

            // Find all radio buttons on the page
            List<WebElement> radioButtons = driver.findElements(By.cssSelector("input[type='radio']"));

            // Get the count of radio buttons
            int totalRadioButtons = radioButtons.size();
            System.out.println("Total number of radio buttons: " + totalRadioButtons);
        } finally {
            // Close the WebDriver
            driver.quit();
        }
    }
}

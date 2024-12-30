package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitchingTest {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open GeeksforGeeks practice page with an iframe
        driver.get("https://www.geeksforgeeks.org/html-iframes/");

        // Switch to the iframe by its name or ID
        driver.switchTo().frame("frame1");

        // Perform actions within the frame
        WebElement frameElement = driver.findElement(By.xpath("//a[@href='/']"));
        frameElement.click();

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Perform actions in the default content
        WebElement defaultElement = driver.findElement(By.cssSelector("h1.entry-title"));
        System.out.println("Page title: " + defaultElement.getText());

        // Close the browser
        driver.quit();
    }
}

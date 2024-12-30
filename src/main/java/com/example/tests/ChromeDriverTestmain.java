package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverTestmain {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the local HTML file (update the path to your file)
        driver.get("/SeleniumChromeAutomation/src/main/java/com/example/tests/frame_example.html");

        // Switch to the frame by ID
        driver.switchTo().frame("iframe_a");

        // Identify element inside the frame
        WebElement frameElement = driver.findElement(By.tagName("h1"));
        System.out.println("Text inside frame: " + frameElement.getText());

        // Switch back to the main content
        driver.switchTo().defaultContent();

        // Identify element outside the frame
        WebElement outsideFrameElement = driver.findElement(By.tagName("h3"));
        System.out.println("Text outside frame: " + outsideFrameElement.getText());

        // Close the browser
        driver.quit();
    }
}

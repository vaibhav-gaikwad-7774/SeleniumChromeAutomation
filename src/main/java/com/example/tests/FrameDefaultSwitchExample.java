package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameDefaultSwitchExample {
    public static void main(String[] args) {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // URL launch
            driver.get("http://www.example.com"); // Replace with a site that contains an iframe

            // Assuming there's an iframe with id or name "iframe_example"
            driver.switchTo().frame("iframe_example");

            // Identify and interact with an element inside the frame
            WebElement frameElement = driver.findElement(By.tagName("h1"));
            System.out.println("Text inside frame: " + frameElement.getText());

            // Switch back to the main content
            driver.switchTo().defaultContent();

            // Identify and interact with an element outside the frame
            WebElement outsideFrameElement = driver.findElement(By.tagName("h2"));
            System.out.println("Text outside frame: " + outsideFrameElement.getText());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
        }
    }
}

package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitchTest11 {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // URL launch - Replace this URL with an actual page containing an iframe for real tests
        driver.get("https://www.w3schools.com/html/html_iframe.asp");

        // Switch to the iframe using WebElement
        WebElement iframe = driver.findElement(By.xpath("//iframe[@title='W3Schools HTML Tutorial']"));
        driver.switchTo().frame(iframe);

        // Verify text inside the iframe
        String iframeText = driver.getPageSource();
        if (iframeText.contains("HTML is the standard markup language for creating Web pages")) {
            System.out.println("Text inside frame is present.");
        } else {
            System.out.println("Text inside frame is not present.");
        }

        // Find an element inside the iframe and interact with it
        WebElement elementInFrame = driver.findElement(By.xpath("//a[@href='/']"));
        System.out.println("Text inside frame: " + elementInFrame.getText());

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Verify text outside the iframe
        WebElement mainPageElement = driver.findElement(By.cssSelector("h1"));
        System.out.println("Text outside frame: " + mainPageElement.getText());

        // Close the browser
        driver.quit();
    }
}

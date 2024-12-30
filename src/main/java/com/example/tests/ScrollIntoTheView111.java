package com.example.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager

public class ScrollIntoTheView111 {

    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the driver
        WebDriver driver = new ChromeDriver();

        // Launch the website
        driver.get("https://testsigma.com/");

        // Maximize the window
        driver.manage().window().maximize();

        // Set an implicit wait of 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Identify the xpath of the element
        WebElement element = driver.findElement(By.xpath("//span[text()='Sign up for free']"));

        // Use scrollIntoView to scroll to the "Sign up for free" button
        js.executeScript("arguments[0].scrollIntoView();", element);

        // Optional: Close the driver
        driver.close();
    }
}

package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverTest111 {
	public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the website
        driver.get("https://www.geeksforgeeks.org/");

        // Targeting XPath of the web element
        WebElement targetDiv = driver.findElement(By.xpath("//*[@id='comp']/div[2]/div[1]/div[1]"));

        if (targetDiv.isDisplayed()) {
            // Execute JavaScript to change the 'id' attribute of the element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].setAttribute('id', 'newId');", targetDiv);

            // Verifying if the attribute has been changed
            String newId = targetDiv.getAttribute("id");
            System.out.println("New ID attribute value: " + newId);

        } else {
            System.out.println("Element not found or not visible.");
        }

        // Optionally, you can add a delay to observe the change before closing the browser
        Thread.sleep(3000);

        // Close the browser
        driver.quit();
    }
}

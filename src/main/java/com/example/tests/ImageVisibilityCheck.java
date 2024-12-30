package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageVisibilityCheck {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the desired URL
            driver.get("https://geeksforgeeks.org");

            // Locate the image using its XPath
            WebElement image = driver.findElement(By.xpath("//img[@src='https://media.geeksforgeeks.org/gfg-gg-logo.svg']"));

            // Check if the image is displayed
            if (image.isDisplayed()) {
                System.out.println("Logo present");
            } else {
                System.out.println("Logo NOT present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

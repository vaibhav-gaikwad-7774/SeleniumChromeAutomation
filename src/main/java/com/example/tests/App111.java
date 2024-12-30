package com.example.tests;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class App111 {
    public static void main(String[] args) throws Exception {
        // Automatically setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the WebDriver instance with ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the desired URL
        driver.get("https://globbertrot.github.io/images");

        try {
            // Locate all image elements on the webpage
            List<WebElement> listOfImages = driver.findElements(By.tagName("img"));

            // Print the 'src' attribute of each image
            for (WebElement image : listOfImages) {
                System.out.println(image.getAttribute("src"));
            }

        } catch (NoSuchElementException e) {
            System.out.println("No images found.");
        }

        // Close the browser session
        driver.quit();
    }
}

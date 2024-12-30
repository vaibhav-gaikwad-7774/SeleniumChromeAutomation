package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class FileUploadTest {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
        
        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            // Navigate to the target URL
            driver.get("https://easyupload.io");

            // Locate the file input element
            WebElement uploadElement = driver.findElement(By.className("dz-hidden-input"));
            // Provide the file path using sendKeys
            uploadElement.sendKeys("C:\\Users\\GFG0329\\Downloads\\nestedframes.html");

            // Locate and click the submit button
            WebElement submitButton = driver.findElement(By.id("upload"));
            submitButton.click();

            // Wait for the upload to complete
            Thread.sleep(5000);

            // Locate the element that indicates upload status
            WebElement fileNameElement = driver.findElement(By.id("upload-label-1"));

            // Check if the upload status indicates success
            if (fileNameElement.isDisplayed() && fileNameElement.getText().equals("Upload Success!")) {
                System.out.println("File uploaded successfully and visible in the preview.");
            } else {
                System.out.println("File is not visible in the preview.");
            }
        } catch (Exception e) {
            // Print any exceptions that occur
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

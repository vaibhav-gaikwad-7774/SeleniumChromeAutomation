package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadAutomation {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize the Chrome WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open URL
            driver.get("http://demo.automationtesting.in/FileDownload.html");

            // Enter text
            driver.findElement(By.id("textbox")).sendKeys("Hello world");

            // Generate Text File
            driver.findElement(By.id("createTxt")).click();

            // Click on Download Button
            driver.findElement(By.id("link-to-download")).click();

            // Print confirmation message to console
            System.out.println("File download has been triggered successfully.");

        } catch (Exception e) {
            // Print error message if something goes wrong
            System.out.println("An error occurred during file download: " + e.getMessage());
        } finally {
            // Close the driver after the actions are complete
            driver.quit();
        }
    }
}

package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileWriter;
import java.io.IOException;

public class ZerodhaPageSaveTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Zerodha
        driver.get("https://zerodha.com/");

        // Get the page source
        String pageSource = driver.getPageSource();

        // Directory where the file will be saved
        String directoryPath = "D:\\gfg329\\Docs";
        // File path
        String filePath = directoryPath + "/saved_webpage.html";

        // Save the page source to a file
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(pageSource);
            System.out.println("Webpage saved successfully at: " + filePath);
        } catch (IOException e) {
            System.out.println("Error while saving webpage: " + e.getMessage());
        }

        // Close the browser
        driver.quit();
    }
}

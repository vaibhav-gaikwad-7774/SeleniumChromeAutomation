package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WebTextExtractor {

    public static void main(String[] args) {
        // Use WebDriverManager to set up the ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the target web page
            driver.get("https://example.com");

            // Locate the element containing the text
            WebElement element = driver.findElement(By.tagName("body")); // Adjust selector as needed

            // Extract text from the element
            String pageText = element.getText();

            // Save the extracted text to a file
            saveTextToFile("output.txt", pageText);
            System.out.println("Text extracted and saved successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }

    // Method to save text to a file
    private static void saveTextToFile(String filename, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}

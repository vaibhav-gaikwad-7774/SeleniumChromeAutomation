package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExtractTextExample {
    public static void main(String[] args) {
        // Initialize the SafariDriver
        WebDriver driver = new SafariDriver();
        
        // Navigate to the web page
        driver.get("https://example.com");

        // Locate the element containing the text
        WebElement textElement = driver.findElement(By.id("element-id")); // Replace with actual element locator

        // Extract the text from the element
        String extractedText = textElement.getText();

        // Save the extracted text to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("extractedText.txt"))) {
            writer.write(extractedText);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }

        // Close the browser
        driver.quit();
    }
}

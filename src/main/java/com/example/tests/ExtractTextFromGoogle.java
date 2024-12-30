package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExtractTextFromGoogle {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Launch Google
            driver.get("https://www.google.com");

            // Locate the element containing the text (for demonstration, extracting text from a specific element)
            // For this example, let's extract the text from the Google logo alt attribute
            WebElement logoElement = driver.findElement(By.id("hplogo"));
            String logoAltText = logoElement.getAttribute("alt");

            // Output the extracted text to the console
            System.out.println("Extracted Text from Google Logo: " + logoAltText);

            // Define the absolute path for saving the file
            String filePath = "C:/path/to/your/directory/extractedText.txt"; // Change this to your desired path

            // Save the extracted text to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write("Google Logo Alt Text: " + logoAltText);
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

package seleniumpractice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtractTextToFile {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        try {
            // Set implicit wait
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            
            // Launch URL
            driver.get("https://example.com"); // Replace with your URL
            
            // Locate the element containing the text
            WebElement textElement = driver.findElement(By.id("element-id")); // Update with actual locator
            
            // Extract the text from the element
            String extractedText = textElement.getText();
            System.out.println("Extracted Text: " + extractedText);
            
            // Save the extracted text to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("extractedText.txt"))) {
                writer.write(extractedText);
            } catch (IOException e) {
                System.err.println("An error occurred while writing to the file: " + e.getMessage());
            }
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

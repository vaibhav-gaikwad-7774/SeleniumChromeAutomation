package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteKeystrokeExample {
    public static void main(String[] args) {
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open the GeeksforGeeks website
            driver.get("https://www.geeksforgeeks.org/");

            // Locate the search field on the homepage
            WebElement searchField = driver.findElement(By.xpath("//input[@type='text']"));

            // Input some text into the search field
            searchField.sendKeys("Data Structures");

            // Print the current text in the search field
            System.out.println("Before adding extra text: " + searchField.getAttribute("value"));

            // Add additional text before deleting
            searchField.sendKeys(" in Java");

            // Print the updated text after adding extra text
            System.out.println("After adding text: " + searchField.getAttribute("value"));

            // Send the DELETE keystroke (backspace to delete the last character)
            searchField.sendKeys(Keys.BACK_SPACE);

            // Print the updated text in the search field after deletion
            System.out.println("After DELETE: " + searchField.getAttribute("value"));
            
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

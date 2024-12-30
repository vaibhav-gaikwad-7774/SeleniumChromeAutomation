package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeDriverTest11 {
    public static void main(String[] args) throws InterruptedException {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Navigate to the desired webpage
            driver.get("https://trends.builtwith.com/websitelist/Responsive-Tables"); // Update with the correct URL

            // Pause to see the page load
            Thread.sleep(3000); // Wait for 3 seconds

            // Locate the td element with the text "$163m+"
            WebElement targetElement = driver.findElement(By.xpath("//tr[@data-domain='generalmills.com']/td[text()='$163m+']"));

            // Pause to observe the element before interacting with it
            Thread.sleep(2000); // Wait for 2 seconds

            // Get the following sibling element (the next 'td' in the same row)
            WebElement followingSibling = targetElement.findElement(By.xpath("following-sibling::td[1]"));

            // Print the text of the following sibling element
            System.out.println("Following Sibling Text: " + followingSibling.getText());

            // Pause to observe the printed output
            Thread.sleep(2000); // Wait for 2 seconds

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Pause before closing the browser
            Thread.sleep(2000); // Wait for 2 seconds to observe the browser before closing

            // Close the browser
            driver.quit();
        }
    }
}

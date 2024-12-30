package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class FileUploadExample {
    public static void main(String[] args) {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize the browser window
            driver.manage().window().maximize();

            // Navigate to the specified URL
            driver.get("https://demoqa.com/upload-download");

            // Find the "Choose File" button element on the webpage
            WebElement button = driver.findElement(By.xpath("//input[@id='uploadFile']"));

            // Use Actions class to move to the "Choose File" button and click on it
            Actions act = new Actions(driver);
            act.moveToElement(button).click().perform();

            // Initialize the Robot class (used for simulating keyboard and mouse actions)
            Robot rb = new Robot();
            rb.delay(2000);  // Wait for 2 seconds to ensure the file dialog is open

            // Copy the file path to the clipboard
            StringSelection ss = new StringSelection("Downloads\\nestedframes.html");//path which you want to upload the file 
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            // Simulate pressing CTRL + V to paste the copied file path
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);

            // Simulate pressing ENTER to confirm the file selections
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);

            // Print a message to the console indicating that the file has been uploaded
            System.out.println("File Uploaded");
        } catch (Exception e) {
            // Print any exception that occurs during execution
            e.printStackTrace();
        } finally {
            // Close the browser after the script completes
            driver.quit();
        }
    }
}

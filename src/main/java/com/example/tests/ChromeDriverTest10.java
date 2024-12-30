package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.Map;

public class ChromeDriverTest10 {
    public static void main(String[] args) throws InterruptedException {
        // Path to the directory where the file will be downloaded
        String downloadFilepath = "C:\\Users\\YourUsername\\Downloads";

        // Setting up Chrome preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance with options
        WebDriver driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        try {
            // Navigate to the sample file download page
            driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");

            // Click on the download link
            WebElement downloadLink = driver.findElement(By.xpath("//a[text()='Download sample pdf file']"));
            downloadLink.click();

            // Wait for the download to complete (time may vary depending on file size and network speed)
            Thread.sleep(5000);

            System.out.println("Download completed successfully!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

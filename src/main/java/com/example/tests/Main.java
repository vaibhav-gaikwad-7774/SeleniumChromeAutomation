package com.example.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        try {
            // Make a direct HTTP request using HttpURLConnection
            URL url = new URL("https://www.geeksforgeeks.org/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int statusCode = connection.getResponseCode();
            System.out.println("HTTP Status Code: " + statusCode);

            // Check if the request was successful
            if (statusCode == HttpURLConnection.HTTP_OK) {
                System.out.println("Connection successful.");
            } else {
                System.out.println("Failed to connect, status code: " + statusCode);
            }

            // Set up Selenium WebDriver using WebDriverManager to handle ChromeDriver setup
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            // Initialize the ChromeDriver with the specified options
            WebDriver driver = new ChromeDriver(options);

            // Navigate to the URL using WebDriver
            driver.get("https://www.geeksforgeeks.org/");
            System.out.println("Title of the page is: " + driver.getTitle());

            // Close the browser
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

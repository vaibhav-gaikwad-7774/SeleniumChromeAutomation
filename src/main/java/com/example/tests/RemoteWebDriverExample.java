package com.example.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverExample {
    public static void main(String[] args) {
        try {
            // Set up ChromeOptions for desired capabilities
            ChromeOptions options = new ChromeOptions();
            options.setCapability("browserName", "chrome");
            options.setCapability("platformName", "WINDOWS");

            // Initialize RemoteWebDriver with Selenium Grid Hub URL and capabilities
            WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);

            // Navigate to a webpage
            driver.get("https://www.example.com");

            // Print the title of the current webpage
            System.out.println("Title: " + driver.getTitle());

            // Close the browser
            driver.quit();
        } catch (MalformedURLException e) {
            System.err.println("Invalid URL for the Selenium Grid Hub.");
            e.printStackTrace();
        }
    }
}

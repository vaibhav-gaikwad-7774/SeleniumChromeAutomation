package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.lang.ProcessHandle;

public class GetBrowserPID {
    public static void main(String[] args) {
        // Set up WebDriverManager to automatically handle the driver setup
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        ChromeDriver driver = new ChromeDriver();

        try {
            // Get the process handle for the browser process
            ProcessHandle processHandle = ProcessHandle.current();

            // Retrieve and print the PID of the ChromeDriver process
            long pid = processHandle.pid();
            System.out.println("Browser PID: " + pid);

            // Perform some operations with the browser
            driver.get("https://www.geeksforgeeks.org");

            // Sleep for a few seconds to keep the browser open for observation
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

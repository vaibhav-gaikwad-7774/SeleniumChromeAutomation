package com.example.tests;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Application {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Open the GeeksforGeeks website
        driver.get("https://www.geeksforgeeks.org/");

        // Add a cookie named "Selenium Test"
        Cookie seleniumTestCookie = new Cookie("Selenium Test", "123456");
        driver.manage().addCookie(seleniumTestCookie);

        // Retrieve and print the "Selenium Test" cookie
        Cookie retrievedCookie = driver.manage().getCookieNamed("Selenium Test");
        if (retrievedCookie != null) {
            System.out.println("Cookie Retrieved: " + retrievedCookie);
        } else {
            System.out.println("No 'Selenium Test' cookie found.");
        }

        // Close the browser
        driver.quit();
    }
}

package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SessionCheck {
    public static void main(String[] args) {
        // Step 1: Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Step 2: Create ChromeOptions to connect to an existing browser session
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9222");

        // Step 3: Create an instance of ChromeDriver with existing session options
        WebDriver driver = new ChromeDriver(options);

        // Step 4: Use the WebDriver to interact with the existing browser session
        driver.get("https://www.google.com");

        // Step 5: Perform an action on the page, like searching for something
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.submit();

        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Step 6: Quit the browser session
        driver.quit();
    }
}

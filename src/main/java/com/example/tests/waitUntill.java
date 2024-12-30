package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class waitUntill {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Amazon
        driver.get("https://www.amazon.com");

        // Wait until the title contains "Amazon.com"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("Amazon.com"));

        // Validate the title of the page
        String pageTitle = driver.getTitle();
        if (pageTitle.contains("Amazon.com")) {
            System.out.println("Title validation passed. Current title: " + pageTitle);
        } else {
            System.out.println("Title validation failed. Current title: " + pageTitle);
        }

        // Enter search query
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Selenium WebDriver");

        // Click search button
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Wait until search results are present
        System.out.println("Waiting for search results...");
        List<WebElement> searchResults = wait.until(
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']"))
        );

        // Print the number of search results
        System.out.println("Number of search results: " + searchResults.size());

        // Print the titles of the first 8 search results
        for (int i = 0; i < Math.min(searchResults.size(), 8); i++) {
            WebElement titleElement = searchResults.get(i).findElement(By.tagName("h2"));
            String title = titleElement.getText();
            System.out.println("Title: " + title);
        }

        // Close the browser
        driver.quit();
    }
}

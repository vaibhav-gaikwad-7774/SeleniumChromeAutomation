package com.example.tests;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {
	 public static void main(String[] args) {
	        // Initialize the Firefox WebDriver
		 WebDriverManager.chromedriver().setup();

	        // Initialize ChromeDriver instance
	        WebDriver driver = new ChromeDriver();

	        // Maximize the browser window
	        driver.manage().window().maximize();
	        
	        // Open the webpage
	        driver.get("https://www.geeksforgeeks.org/");
	        
	        // Declare and initialize a FluentWait
	        FluentWait<WebDriver> wait = new FluentWait<>(driver)
	            .withTimeout(Duration.ofSeconds(5))         // Set the timeout
	            .pollingEvery(Duration.ofMillis(250))       // Set the polling frequency
	            .ignoring(NoSuchElementException.class);    // Ignore specific exceptions
	        
	        // Wait until an alert is present and store it in an Alert object
	        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	        
	        // Perform actions on the alert, such as accepting it
	        alert.accept();
	        
	        // Close the browser
	        driver.quit();
	    }
	}



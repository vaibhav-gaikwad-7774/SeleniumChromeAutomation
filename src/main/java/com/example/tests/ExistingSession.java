package com.example.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExistingSession {

   public static void main(String[] args) throws Exception {
      
      // Set up ChromeDriver using WebDriverManager
      WebDriverManager.chromedriver().setup();
      
      // Configure Chrome to attach to an existing session via debuggerAddress
      ChromeOptions options = new ChromeOptions();
      options.setExperimentalOption("debuggerAddress", "localhost:9222");  // Ensure this matches the port used to start Chrome

      // Initialize WebDriver with ChromeOptions
      WebDriver driver = new ChromeDriver(options);

      // Perform actions using the existing session
      driver.get("https://www.example.com");
      System.out.println("Title of the page is: " + driver.getTitle());

      // Close the driver
      driver.quit();
   }
}

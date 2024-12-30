package com.example.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadWt {
   public static void main(String[] args) throws InterruptedException {
      // Setup ChromeDriver using WebDriverManager
      WebDriverManager.chromedriver().setup();
      
      // Initialize ChromeDriver instance
      WebDriver driver = new ChromeDriver();
      
      // Set time for page load (4 seconds)
      driver.manage().timeouts().pageLoadTimeout(4, TimeUnit.SECONDS);
      
      try {
          // Attempt to open GeeksforGeeks website
          driver.get("https://www.geeksforgeeks.org/");
          System.out.println("Page loaded successfully within the timeout.");
      } catch (TimeoutException e) {
          // If the page takes longer than the timeout
          System.out.println("Page load timed out after 4 seconds.");
      } finally {
          // Close the browser
          driver.quit();
      }
   }
}

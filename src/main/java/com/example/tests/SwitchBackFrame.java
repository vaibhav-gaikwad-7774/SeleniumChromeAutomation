package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class SwitchBackFrame {
   public static void main(String[] args) {
      // Setup ChromeDriver using WebDriverManager
      WebDriverManager.chromedriver().setup();
      
      // Initialize ChromeDriver instance
      WebDriver driver = new ChromeDriver();
      
      try {
          // Navigate to the test page
          driver.get("https://the-internet.herokuapp.com/frames");
          
          // Set implicit wait
          driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
          
          // Identify and click the "Nested Frames" link
          driver.findElement(By.partialLinkText("Nested")).click();
          
          // Switch to the frame by frame name ("frame-bottom")
          driver.switchTo().frame("frame-bottom");
          
          // Locate the body element inside the frame and print its text
          WebElement frameBody = driver.findElement(By.cssSelector("body"));
          System.out.println("Frame text: " + frameBody.getText());
          
          // Switch back to the main page content
          driver.switchTo().defaultContent();
      } finally {
          // Close the browser
          driver.quit();
      }
   }
}

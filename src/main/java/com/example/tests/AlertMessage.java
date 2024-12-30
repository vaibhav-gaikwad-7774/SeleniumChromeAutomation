package com.example.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class AlertMessage{
	
   public static void main(String[] args) throws Exception {
	   
   	  // Set up ChromeDriver using WebDriverManager
      WebDriverManager.chromedriver().setup(); 
      WebDriver driver = new ChromeDriver();
      //implicit wait
      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
      //URL launch
      driver.get("https://the-internet.herokuapp.com/javascript_alerts");
      Thread.sleep(1000);
      // identify element
      WebElement l = driver.
      findElement(By.xpath("//*[text()='Click for JS Alert']"));
      l.click();
      Thread.sleep(1000);
      //switch focus to alert
      Alert a = driver.switchTo().alert();
      //get alert text
      String s= driver.switchTo().alert().getText();
      System.out.println("Alert text is: " + s);
      //accepting alert
      a.accept();
      driver.quit();
   }
}




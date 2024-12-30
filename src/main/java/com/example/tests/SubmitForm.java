package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class SubmitForm {

	
	   public static void main(String[] args) throws Exception {
	  //    System.setProperty("webdriver.gecko.driver",
	    //     "C:\Users\ghs6kor\Desktop\Java\geckodriver.exe");
	      WebDriverManager.chromedriver().setup();
	      WebDriver driver = new ChromeDriver();
	      //implicit wait
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      //URL launch
	      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	      // identify element within form
	      WebElement m=driver.findElement(By.name("username"));
	      m.sendKeys("Admin");
	      WebElement n=driver.findElement(By.name("password"));
	      n.sendKeys("admin123");
	      //submit form
	      WebElement o=driver.findElement(By.xpath("//button[@type='submit']"));
	      o.submit();
	      Thread.sleep(1000);
	      System.out.println("Page title: " + driver.getTitle());
	      driver.close();
	   }
	}




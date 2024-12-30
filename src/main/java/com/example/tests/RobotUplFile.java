package com.example.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
public class RobotUplFile{
	 public static void main(String[] args) throws AWTException {
	        // Set up ChromeDriver using WebDriverManager
	        WebDriverManager.chromedriver().setup();

	        // Initialize ChromeDriver instance
	        WebDriver driver = new ChromeDriver();
      driver.get("http://my.monsterindia.com/seeker/registration");
      // scroll to reach upload button
      JavascriptExecutor j = (JavascriptExecutor)driver;
      j.executeScript("scroll(0,500)");
      // file path passed as parameter to StringSelection
      StringSelection s = new StringSelection("C:\\Users\\GFG0329\\Downloads");
      // Clipboard copy
      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s,null);
      //identify element and click
      driver.findElement(By.xpath("//*[text()='Choose file']")).click();
      // Robot object creation
      Robot r = new Robot();
      //pressing enter
      r.keyPress(KeyEvent.VK_ENTER);
      //releasing enter
      r.keyRelease(KeyEvent.VK_ENTER);
      //pressing ctrl+v
      r.keyPress(KeyEvent.VK_CONTROL);
      r.keyPress(KeyEvent.VK_V);
      //releasing ctrl+v
      r.keyRelease(KeyEvent.VK_CONTROL);
      r.keyRelease(KeyEvent.VK_V);
      //pressing enter
      r.keyPress(KeyEvent.VK_ENTER);
      //releasing enter
      r.keyRelease(KeyEvent.VK_ENTER);
   }
}

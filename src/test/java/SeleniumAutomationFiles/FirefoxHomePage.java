package SeleniumAutomationFiles;

//Importing All Necessary Items
import java.io.*;
import java.lang.Thread;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxHomePage {
 public static void main(String[] args)
 {
     // Try-Catch Block For Implementing Sleep Method
     try {
         // String Where Home Page URL Is Stored
         String baseUrl = "https://www.google.com/";
       
         // Implementation of SetProperty Method
         System.setProperty(
             "webdriver.gecko.driver",
             "test/resources/geckodriver.exe");
       
         // Creating New Object driver Of Webdriver
         WebDriver driver = new FirefoxDriver();
       
         // Calling the Home Page By Using Get() Method
         driver.get(baseUrl);
       
         // Delaying The Output
         Thread.sleep(2000);
       
         // Closing The Opened Window
         driver.quit();
     }
     catch (Exception e) {
         // Catching The Exception
         System.out.println(e);
     }
 }
}
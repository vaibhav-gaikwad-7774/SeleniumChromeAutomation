package SeleniumAutomationFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTitleOfPage {
    public static void main(String[] args) {
        
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Set implicit wait to handle elements loading time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
            driver.get("https://www.geeksforgeeks.org/");
            
            String pageTitle = driver.getTitle();
            System.out.println("Title of the page: " + pageTitle);
            driver.quit();
    }
    
}

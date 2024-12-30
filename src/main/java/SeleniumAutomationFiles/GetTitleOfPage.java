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
        
        try {
            // Navigate to a sample website
            driver.get("https://saucelabs.com/");
            
            // Fetch and print the title of the page
            String pageTitle = driver.getTitle();
            System.out.println("Title of the page: " + pageTitle);
        } catch (Exception e) {
            // Handle any exceptions if they occur
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Ensure that the browser is closed after execution
            driver.quit();
        }
    }
}

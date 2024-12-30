package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.interactions.Actions;

public class RightClickOperation {
    public static void main(String[] args) {
        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
       
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String u = "https://www.geeksforgeeks.org/";
        driver.get(u);
        
        // Identify element
        WebElement m = driver.findElement(By.linkText("Foundational Courses"));
        
        // MoveToElement and contextClick
        Actions act = new Actions(driver);
        act.moveToElement(m).contextClick().build().perform();
        
        // Output message indicating success
        System.out.println("Human-like mouse movements with Selenium executed successfully");
        
        // Close the browser
        driver.quit();
    }
}

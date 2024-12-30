package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HandleImage {
    public static void main(String[] args) {
        
        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Navigate to Oracle Page
        driver.navigate().to("http://www.oracle.com/technetwork/java/javase/downloads/index.html");
        
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        try {
            // Wait for and click on the close icon using class name
            WebElement closeIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className("icn-close")));
            closeIcon.click();
           
        } catch (Exception e) {
            System.out.println("Close icon not found or could not be clicked. Continuing...");
        }
        
        try {
            // Wait for and click on the Java Image
            WebElement javaImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/section[2]/div"))); // Update the XPath as needed
            javaImage.click();
            System.out.println("Java Download Image Link is clicked");
        } catch (Exception e) {
            System.out.println("Java Download Image not found or could not be clicked.");
        } finally {
            // Close the browser
            driver.quit(); // Optional: Close the browser after the operation
        }
    }
}

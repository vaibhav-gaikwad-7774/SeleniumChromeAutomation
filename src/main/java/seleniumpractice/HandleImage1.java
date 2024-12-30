package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HandleImage1 {
    public static void main(String[] args) {
        
        // Set up WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Maximize the browser
        driver.manage().window().maximize();
        
        // Navigate to Oracle Page
        driver.navigate().to("https://www.geeksforgeeks.org/");
        
        // Initialize WebDriverWait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Try to click the close icon if it exists
//        try {
//            // Wait for and click on the close icon using class name
//            WebElement closeIcon = wait.until(ExpectedConditions.elementToBeClickable(By.className("icn-close")));
//            closeIcon.click();
//            System.out.println("Close icon is clicked successfully.");
//        } catch (Exception e) {
//            System.out.println("Close icon not found or could not be clicked. Continuing...");
//        }
        
        // Try to click on the Java image
        try {
            // Wait for and click on the Java Image
            WebElement geeksforgeeks = driver.findElement(By.className("headerMainLogo")); // Update XPath as needed
            geeksforgeeks.click();
            System.out.println("Geeksforgeeks logo clicked successfully");
        } catch (Exception e) {
            System.out.println("Geeksforgeeks logo not found or could not be clicked.");
        } finally {
            // Close the browser
            driver.quit(); // Optional: Close the browser after the operation
        }
    }
}

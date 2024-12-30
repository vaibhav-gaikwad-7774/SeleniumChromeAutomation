package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager

public class CustomExpectedCondition {
    public static void main(String[] args) {
        try {
            // Set up WebDriverManager for ChromeDriver
            WebDriverManager.chromedriver().setup();
            
            WebDriver driver = new ChromeDriver();
            
            // Open the GeeksforGeeks homepage
            driver.get("https://www.geeksforgeeks.org/");
            
            // Maximize window
            driver.manage().window().maximize();
            
            // Click on the 'Practice Problems' link
            WebElement practiceProblemsLink = driver.findElement(By.xpath("//a[@href='/explore/?page=1&sortBy=submissions&auth&utm_source=auth&utm_medium=profile&utm_campaign=empty_header']"));
            practiceProblemsLink.click();
            
            // Replace WebDriverWait with Thread.sleep (e.g., 10 seconds)
            Thread.sleep(10000); // 10 seconds sleep to wait for the "Solve Problem" button to load
            
            // Check if the 'Solve Problem' button is visible
            WebElement solveButton = driver.findElement(By.xpath("//a[contains(text(), 'Solve Problem')]"));
            if (solveButton != null && solveButton.isDisplayed()) {
                System.out.println("Element found.");
            }
            
            // Close the browser
            driver.quit();
            
        } catch (InterruptedException e) {
            System.out.println("Thread was interrupted.");
        } catch (Exception e) {
            System.out.println("'Solve Problem' button not found or some error occurred.");
        }
    }
}

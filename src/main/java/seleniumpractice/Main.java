package seleniumpractice;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Main {
    public static void main(String[] args) {
        // Setup WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();

        // Use the link you want to open
        driver.get("https://www.geeksforgeeks.org/");

        try {
            // Locate element using partial link text
            WebElement partialLinkElement = driver.findElement(By.linkText("I am Hello World!"));
          
            // Click on the link
            partialLinkElement.click();
        } catch (Exception e) {
            System.out.println("The link was not found.");
        }

        // Close the browser
        driver.quit();
    }
}

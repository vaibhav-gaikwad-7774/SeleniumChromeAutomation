package seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class Click_Hidden {
    public static void main(String[] args) {
        // Use WebDriverManager to automatically manage the ChromeDriver binary
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            // Navigate to the target web page
            driver.get("https://www.letskodeit.com/practice");
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            // Locate the hidden element using its ID, class, or any suitable locator
            WebElement hiddenElement = driver.findElement(By.id("displayed-text"));

            // Use JavaScriptExecutor to click on the hidden element
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", hiddenElement);

            // Add a message to confirm that the click was performed
            System.out.println("Hidden element clicked successfully!");

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}

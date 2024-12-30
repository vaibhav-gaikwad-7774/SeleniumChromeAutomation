package seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import java.time.Duration;

public class SeleniumTestnew {
    public static void main(String[] args) {
        // Setup WebDriverManager to handle ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Initialize WebDriver with ChromeDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Wikipedia homepage
            driver.get("https://www.wikipedia.org/");

            // Maximize the window
            driver.manage().window().maximize();

            // Initialize explicit wait
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

            // Wait for the "English" link to be visible
            WebElement englishLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='js-link-box-en']")));

            // Wait for the "English" link to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(englishLink));

            // Clicking the "English" link using JavaScript Executor as a fallback
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", englishLink);

            System.out.println("English link clicked successfully!");

        } catch (Exception e) {
            // Print out the error in case of failure
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser after the operation
            driver.quit();
        }
    }
}

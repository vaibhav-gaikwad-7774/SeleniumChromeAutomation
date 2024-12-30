package seleniumpractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.TimeoutException;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import java.time.Duration;

public class SeleniumTestmjzx {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        // Setting page load timeout
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        try {
            driver.get("http://example.com");
            System.out.println("Page loaded successfully.");
        } catch (TimeoutException e) {
            System.out.println("Page load timeout exceeded. Retrying...");
            try {
                // Retry logic, reload page or handle as necessary
                driver.navigate().refresh();
                driver.get("http://example.com");
                System.out.println("Page loaded on retry.");
            } catch (TimeoutException retryException) {
                System.out.println("Retry failed: " + retryException.getMessage());
            }
        } finally {
            driver.quit();
        }
    }
}

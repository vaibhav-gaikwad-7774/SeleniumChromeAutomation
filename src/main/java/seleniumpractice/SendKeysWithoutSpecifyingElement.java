package seleniumpractice;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SendKeysWithoutSpecifyingElement {
    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/inputs"); // URL
        Thread.sleep(1000); // Wait for page load

        // Use JavaScript to focus on the first input element on the page
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("document.querySelector('input').focus();");
        Thread.sleep(1000); // Wait to confirm focus

        // Use Actions class to send keys to the focused element
        Actions actions = new Actions(driver);
        actions.sendKeys("5678").perform();
        Thread.sleep(2000); // Wait to observe the input result

        // Print success message in console
        System.out.println("Keys sent successfully without specifying an element!");

        // Close the browser
        driver.quit();
    }
}

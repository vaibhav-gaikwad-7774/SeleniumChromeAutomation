package interactions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Set up WebDriver for Chrome
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testClickButton() {
        // Open Google.com
        driver.get("https://www.google.com");

        // Locate the Search input box and enter a query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        // Locate the Google Search button and click it
        WebElement searchButton = driver.findElement(By.name("btnK"));

        // Wait briefly to ensure the button is clickable
        try {
            Thread.sleep(1000); // Avoid using Thread.sleep; use WebDriverWait in real projects.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        searchButton.click();

        // Verify the title of the results page contains the query
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Selenium WebDriver"));
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

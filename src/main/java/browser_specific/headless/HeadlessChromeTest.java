package browser_specific.headless;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.BaseTest;

public class HeadlessChromeTest extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configure ChromeOptions for headless mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // Use new headless mode
        options.addArguments("--disable-gpu"); // Recommended for headless execution
        options.addArguments("--window-size=1920,1080"); // Set specific window size
        driver = new ChromeDriver(options);
    }

    @Test
    public void testHeadless() {
        // Navigate to the webpage
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Assert that the title contains "Selenium WebDriver"
        assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Title does not match the expected value");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}

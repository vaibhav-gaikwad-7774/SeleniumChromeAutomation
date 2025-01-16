package browser_specific.incognito;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.BaseTest;

public class HeadlessIncognitoChromeTest extends BaseTest {

	private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configure ChromeOptions for headless and incognito mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Enable headless mode
        options.addArguments("--incognito"); // Enable incognito mode
        options.addArguments("--disable-gpu"); // Disable GPU for smoother headless execution
        options.addArguments("--window-size=1920x1080"); // Set window size for better rendering
        driver = new ChromeDriver(options);
    }

    @Test
    public void testHeadlessIncognito() {
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
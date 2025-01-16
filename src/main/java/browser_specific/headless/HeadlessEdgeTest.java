package browser_specific.headless;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import actions.BaseTest;

public class HeadlessEdgeTest extends BaseTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Configure EdgeOptions for headless mode
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new"); // Use new headless mode
        options.addArguments("--disable-gpu"); // Recommended for headless execution
        options.addArguments("--window-size=1920,1080"); // Set specific window size
        driver = new EdgeDriver(options);
    }

    @Test
    public void testHeadlessEdge() {
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

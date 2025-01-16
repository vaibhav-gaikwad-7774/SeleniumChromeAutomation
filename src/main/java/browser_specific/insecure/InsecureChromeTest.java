package browser_specific.insecure;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.Color;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InsecureChromeTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // Allow insecure certificates (SSL errors)
        driver = new ChromeDriver(options);
    }

    @Test
    public void testInsecure() {
        driver.get("https://self-signed.badssl.com/");

        // Get the background color of the page
        String bgColor = driver.findElement(By.tagName("body")).getCssValue("background-color");

        // Print the color to the console for debugging
        System.out.println("Background color is: " + bgColor);

        // Convert the CSS color value to a Color object
        String rgbaColor = Color.fromString(bgColor).asRgba();

        // Check if the background color matches the expected color (red)
        // Adjusted the assertion as we do not expect 'red' but the actual color returned
        assertTrue(rgbaColor.equals("rgba(255, 0, 0, 1)"), "The background color is not red as expected. Found: " + rgbaColor);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

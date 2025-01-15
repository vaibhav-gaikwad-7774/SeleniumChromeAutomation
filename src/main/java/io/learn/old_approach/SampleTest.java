package io.learn.old_approach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SampleTest {

    // Approach-1 used before Selenium WD v4.x - set the system property
    @Test
    public void testWithOldApproach() {
        // For running tests in Chrome
        System.setProperty("webdriver.chrome.driver", "/driver_Files/chromedriver.exe"); // this is mandatory
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");
        assertEquals(driver.getTitle(), "Example Domain", "Title does not match for Chrome");
        driver.quit();

        // For running tests in Edge
        System.setProperty("webdriver.edge.driver", "/driver_Files/edgedriver.exe"); // this is mandatory
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://www.example.com");
        assertEquals(driver1.getTitle(), "Example Domain", "Title does not match for Edge");
        driver1.quit();
    }

    // Approach-2 used before Selenium WD v4.x - use Webdrivermanager library
    @Test
    public void testWithOldApproach2() {
        // Uncomment to test
        /*
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");
        assertEquals(driver.getTitle(), "Example Domain", "Title does not match for Chrome");
        driver.quit();

        WebDriverManager.edgedriver().setup();
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://www.example.com");
        assertEquals(driver1.getTitle(), "Example Domain", "Title does not match for Edge");
        driver1.quit();
        */
    }

    // Approach-3 used after Selenium WD v4.x - no manual work
    @Test
    public void testWithNewApproach() {
        // For running tests in Chrome
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.example.com");
        assertEquals(driver.getTitle(), "Example Domain", "Title does not match for Chrome");
        driver.quit();

        // For running tests in Edge
        WebDriver driver1 = new EdgeDriver();
        driver1.get("https://www.example.com");
        assertEquals(driver1.getTitle(), "Example Domain", "Title does not match for Edge");
        driver1.quit();
    }
}

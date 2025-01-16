package cross_browser;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CrossBrowserTests {

    private WebDriver driver;

    @Test(dataProvider = "getBrowserData")
    public void testTitle(String browser) {
        this.initializeDriver(browser);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertTrue(driver.getTitle().contains("Selenium WebDriver"), "Title does not contain expected text");
    }

    public void initializeDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        driver.manage().window().maximize();
    }

    @DataProvider
    public Object[][] getBrowserData() {
        return new Object[][]{
                {"chrome"},
                {"edge"},
                {"firefox"}
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

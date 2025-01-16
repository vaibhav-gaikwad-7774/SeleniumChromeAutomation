package cross_browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CrossBrowserTests2 {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Get the current thread's WebDriver instance
    private WebDriver getDriver() {
        return driver.get();
    }

    @Test
    @Parameters("browser")
    public void testTitle(@Optional("chrome") String browser) { // Default to "chrome" if no parameter is passed
        System.out.println("The thread ID for " + browser + " is " + Thread.currentThread().getId());
        this.initializeDriver(browser);
        getDriver().get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertEquals(getDriver().getTitle(), "Hands-On Selenium WebDriver with Java", "Title does not match expected value");
    }

    public void initializeDriver(String browser) {
        WebDriver localDriver;
        if (browser.equalsIgnoreCase("chrome")) {
            localDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            localDriver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            localDriver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        localDriver.manage().window().maximize();
        driver.set(localDriver); // Sets the WebDriver for the current thread
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit(); // Quit the driver for the current method
            driver.remove(); // Remove the ThreadLocal reference
        }
    }
}

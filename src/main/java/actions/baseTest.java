package actions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Create a new instance of ChromeDriver
        driver = new ChromeDriver();
        
        // Set implicit wait to handle elements loading time
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        // Maximize browser window
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser after each test
        }
    }

    @AfterClass
    public void afterClassCleanUp() {
        // Perform any additional cleanup, if needed
        System.out.println("After class clean-up executed.");
    }
}

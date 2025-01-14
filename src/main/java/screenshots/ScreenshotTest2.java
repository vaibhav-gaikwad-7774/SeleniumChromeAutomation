package screenshots;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenshotTest2 {

    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testFullPageScreenshotFirefox() throws IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.className("container"), By.tagName("p")));

        byte[] imageBytes = ((FirefoxDriver) driver).getFullPageScreenshotAs(OutputType.BYTES);
        Path destination = Paths.get("fullpage-screenshot-firefox.png");
        Files.write(destination, imageBytes);

        // Replacing assertThat with assertEquals
        assertEquals(true, Files.exists(destination));
    }
}

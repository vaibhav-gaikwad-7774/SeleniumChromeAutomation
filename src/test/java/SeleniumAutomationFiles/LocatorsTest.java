package SeleniumAutomationFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsTest extends baseTest{
public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
            driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
            
            @Test
            void testByIdAndNameLocators() {
                
                // Find elements using By.id() and By.name()
                WebElement usernameField = driver.findElement(By.id("username"));
                usernameField.sendKeys("TestUser");
                
                WebElement passwordField = driver.findElement(By.name("password"));
                passwordField.sendKeys("TestPass");

                WebElement submitButton = driver.findElement(By.id("submit"));
                submitButton.click();

                // Optionally, assert some condition to verify the test's result
                // e.g., check if the current URL is the expected one after submission
                // Assert.assertEquals(driver.getCurrentUrl(), "expectedURL");
            }
            
}
}
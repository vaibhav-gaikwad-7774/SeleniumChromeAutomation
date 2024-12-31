package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsTest extends baseTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testContextAndDoubleClick() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");

        Actions actions = new Actions(driver);

        WebElement dropDown2 = driver.findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropDown2).perform();

        Thread.sleep(3000);  // Wait for the context menu to appear

        WebElement contextMenu2 = driver.findElement(By.id("context-menu-2"));
        Assert.assertTrue(contextMenu2.isDisplayed());

        WebElement dropDown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropDown3).build().perform();
        WebElement contextMenu3 = driver.findElement(By.id("context-menu-3"));
        Assert.assertTrue(contextMenu3.isDisplayed());
           
    }
    
    @Test
    public void testMouseHover() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement compassImage = driver.findElement(By.xpath("/html/body/main/div/div[4]/div[1]/img"));
        actions.moveToElement(compassImage).build().perform();

        WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("p")).near(compassImage));
        Assert.assertEquals(caption.getText(), "Compass");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

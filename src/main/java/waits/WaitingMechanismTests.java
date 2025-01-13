package waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import actions.BaseTest;

public class WaitingMechanismTests extends BaseTest {

    @Test
    public void testImages() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebElement award = driver.findElement(By.id("award"));
        String srcAttribute = award.getDomAttribute("src");
        Assert.assertTrue(srcAttribute.contains("award"), "Expected 'src' attribute to contain 'award'");
    }

    @Test
    public void testImages2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");

        WebElement compassImage = driver.findElement(By.xpath("//img[@src='img/award.png']"));
        String srcAttribute = compassImage.getDomAttribute("src");
        Assert.assertTrue(srcAttribute.contains("award"), "Expected 'src' attribute to contain 'award'");
    }

    @Test
    public void testImplicitWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // wait for 10 seconds before you throw the NSE - no such element exception

        WebElement award = driver.findElement(By.id("award"));
        String srcAttribute = award.getDomAttribute("src");
        Assert.assertTrue(srcAttribute.contains("award"), "Expected 'src' attribute to contain 'award'");
    }

    @Test
    public void testExplicitWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement award = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("award")));

        String srcAttribute = award.getDomAttribute("src");
        Assert.assertTrue(srcAttribute.contains("award"), "Expected 'src' attribute to contain 'award'");
    }

    @Test
    public void testExplicitWait2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

        // 2 + 3
        driver.findElement(By.xpath("//span[text()='2']")).click();
        driver.findElement(By.xpath("//span[text()='+']")).click();
        driver.findElement(By.xpath("//span[text()='3']")).click();
        driver.findElement(By.xpath("//span[text()='=']")).click();

        // waiting for text to become '5'
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isTextMatching = wait.until(ExpectedConditions.textToBe(By.className("screen"), "5"));
        Assert.assertTrue(isTextMatching, "Expected the screen text to be '5'");
    }

    @Test
    public void testFluentWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement award = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("award")));
        String srcAttribute = award.getDomAttribute("src");
        Assert.assertTrue(srcAttribute.contains("award"), "Expected 'src' attribute to contain 'award'");
    }

    @Test
    public void testHardWait() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");
        Thread.sleep(10000); // hard-wait for 10 seconds

        WebElement award = driver.findElement(By.id("award"));
        String srcAttribute = award.getDomAttribute("src");
        Assert.assertTrue(srcAttribute.contains("award"), "Expected 'src' attribute to contain 'award'");
    }
}

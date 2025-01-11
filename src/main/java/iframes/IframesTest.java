package iframes;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import actions.BaseTest;

public class IframesTest extends BaseTest {

    @Test
    public void testIFrames() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");

        // Switched to an iFrame
        driver.switchTo().frame("my-iframe");

        // Interacted with elements in iFrame
        String text = driver.findElement(By.xpath("//p[@class='lead'][1]")).getText();
        System.out.println(text);

        // Switched back to the main window
        driver.switchTo().defaultContent();

        // Interacted with elements on the parent document
        String headerText = driver.findElement(By.xpath("//h5")).getText();
        System.out.println(headerText);

        // Assertion
        Assert.assertEquals(headerText, "Practice site");
    }

    @Test
    public void testIFrames2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/iframes.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("my-iframe"));

        By pTagName = By.tagName("p");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pTagName, 0)); // Wait until p tags > 0
        List<WebElement> paragraphs = driver.findElements(pTagName);

        // Assertion for the size of paragraphs
        Assert.assertEquals(paragraphs.size(), 20);

        driver.switchTo().defaultContent();
        String actualHeaderText = driver.findElement(By.xpath("//h5")).getText();

        // Assertion for the header text
        Assert.assertEquals(actualHeaderText, "Practice site");
    }
}

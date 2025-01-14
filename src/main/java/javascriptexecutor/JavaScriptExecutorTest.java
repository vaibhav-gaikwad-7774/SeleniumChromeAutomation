package javascriptexecutor;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import actions.BaseTest;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void testScrollBy() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "window.scrollBy(0, 1000);"; // should be valid JS code
        jse.executeScript(script);

        System.out.println("Waiting for page state");
    }

    @Test
    public void testScrollIntoView() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement lastParagraphElement = driver.findElement(By.cssSelector("p:last-child"));
        String script = "arguments[0].scrollIntoView();";
        jse.executeScript(script, lastParagraphElement);

        System.out.println("Waiting for page state");
    }

    @Test
    public void testInfiniteScroll() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By tagName = By.tagName("p");
        List<WebElement> paragraphs = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tagName, 0));
        int initialParagraphSize = paragraphs.size(); // 20
        Assert.assertEquals(initialParagraphSize, 20);

        WebElement lastParagraph = driver.findElement(By.xpath(String.format("//p[%d]", initialParagraphSize)));
        String script = "arguments[0].scrollIntoView();";
        jse.executeScript(script, lastParagraph);

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tagName, initialParagraphSize)); //40
    }

    @Test
    public void testColorPicker() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement colorPicker = driver.findElement(By.name("my-colors"));
        String initialColor = colorPicker.getDomAttribute("value");
        System.out.println("The initial color is: " + initialColor);

        Color redColor = new Color(255, 0, 0, 1);
        String script = String.format("arguments[0].setAttribute('value', '%s');", redColor.asHex()); // #ff0000
        jse.executeScript(script, colorPicker);

        String updatedColor = colorPicker.getDomAttribute("value");
        System.out.println("The updated color is: " + updatedColor);
        Assert.assertNotEquals(updatedColor, initialColor);
        Assert.assertEquals(Color.fromString(updatedColor), redColor);
    }

    @Test
    public void testEnablingHiddenElement() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        WebElement hiddenElement = driver.findElement(By.cssSelector("input[name='my-hidden']"));
        Assert.assertFalse(hiddenElement.isDisplayed());

        jse.executeScript("arguments[0].removeAttribute('type');", hiddenElement);
        Assert.assertTrue(hiddenElement.isDisplayed());
    }

    @Test
    public void testAsyncScript() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        Duration pause = Duration.ofSeconds(2);
        String script = "const callback = arguments[arguments.length - 1];" +
                "window.setTimeout(callback, " + pause.toMillis() + ");";

        long initMilliSeconds = System.currentTimeMillis();

        jse.executeAsyncScript(script);
        Duration elapsedTime = Duration.ofMillis(System.currentTimeMillis() - initMilliSeconds);
        System.out.println("The script took " + elapsedTime.toMillis() + " to be executed");
        Assert.assertTrue(elapsedTime.compareTo(pause) >= 0);
    }
}

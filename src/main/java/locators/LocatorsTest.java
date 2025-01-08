package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsTest extends actions.BaseTest {

    public static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

    @Test
    void testByHtmlAttributes() {
        driver.get(URL);

        // By id
        WebElement textById = driver.findElement(By.id("my-text-id"));
        Assert.assertEquals(textById.getDomAttribute("type"), "text");
        Assert.assertEquals(textById.getDomAttribute("myprop"), "myvalue");

        // By name
        WebElement textByName = driver.findElement(By.name("my-text"));
        Assert.assertTrue(textByName.isEnabled());
    }

    @Test
    public void testByTagName() {
        driver.get(URL);

        // By tag name
        WebElement textarea = driver.findElement(By.tagName("textarea"));
        Assert.assertEquals(textarea.getDomAttribute("rows"), "3");
    }

    @Test
    public void testByClassName() {
        driver.get(URL);

        // By class name
        List<WebElement> byClassName = driver.findElements(By.className("form-control"));
        Assert.assertFalse(byClassName.isEmpty());
        Assert.assertEquals(byClassName.get(0).getDomAttribute("name"), "my-text");
    }

    @Test
    void testByLinkText() {
        driver.get(URL);

        // by link text
        WebElement linkByText = driver.findElement(By.linkText("Return to index"));
        Assert.assertEquals(linkByText.getTagName(), "a");
        Assert.assertTrue(linkByText.getDomAttribute("href").contains("index.html"));

        // by partial link text
        WebElement linkByPartialText = driver.findElement(By.partialLinkText("index"));
        Assert.assertEquals(linkByPartialText.getLocation(), linkByText.getLocation());
        Assert.assertEquals(linkByPartialText.getRect(), linkByText.getRect());
    }

    @Test
    void testByCssSelector() {
        driver.get(URL);

        // by CSS selector
        WebElement hidden = driver.findElement(By.cssSelector("input[type=hidden]"));
        Assert.assertFalse(hidden.isDisplayed());
    }

    @Test
    void testByXPath() {
        driver.get(URL);

        // by xpath
        WebElement hidden = driver.findElement(By.xpath("//input[@type='hidden']"));
        Assert.assertFalse(hidden.isDisplayed());
    }
}

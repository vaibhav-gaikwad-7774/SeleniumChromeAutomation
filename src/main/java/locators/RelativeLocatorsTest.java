package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;
import actions.BaseTest;

public class RelativeLocatorsTest extends BaseTest {

    String URL1 = "https://bonigarcia.dev/selenium-webdriver-java/login-form.html";
    String URL2 = "https://demo.guru99.com/V4/";

    @Test
    public void testRelativeLocatorAbove() {
        driver.get(URL1);
        WebElement password = driver.findElement(By.id("password"));
        WebElement username = driver.findElement(RelativeLocator.with(By.tagName("input")).above(password));
        username.sendKeys("user details");
        Assert.assertEquals(username.getDomAttribute("name"), "username");
    }

    @Test
    public void testRelativeLocatorBelow() {
        driver.get(URL1);
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(username));
        password.sendKeys("pass");
        Assert.assertEquals(password.getDomAttribute("name"), "password");
    }

    @Test
    public void testRelativeLocatorLeft() {
        driver.get(URL2);
        WebElement btnReset = driver.findElement(By.name("btnReset"));
        WebElement loginButton = driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(btnReset));
        Assert.assertEquals(loginButton.getDomAttribute("value"), "LOGIN");
        Assert.assertTrue(loginButton.isEnabled());
    }

    @Test
    public void testRelativeLocatorRight() {
        driver.get(URL2);
        WebElement btnLogin = driver.findElement(By.name("btnLogin"));
        WebElement resetButton = driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(btnLogin));
        Assert.assertEquals(resetButton.getDomAttribute("value"), "RESET");
        Assert.assertTrue(resetButton.isEnabled());
    }

    @Test
    public void testRelativeLocatorNearBy() {
        driver.get(URL1);
        WebElement username = driver.findElement(By.id("username"));
        WebElement label = driver.findElement(RelativeLocator.with(By.tagName("label")).near(username));
        Assert.assertEquals(label.getText(), "Login");
    }

    @Test
    public void testRelativeLocatorChaining() {
        driver.get(URL2);
        WebElement password = driver.findElement(By.name("password"));
        WebElement btnReset = driver.findElement(By.name("btnReset"));
        WebElement loginButton = driver.findElement(RelativeLocator.with(By.tagName("input"))
                .below(password)
                .toLeftOf(btnReset));
        Assert.assertEquals(loginButton.getDomAttribute("value"), "LOGIN");
        Assert.assertTrue(loginButton.isEnabled());
    }
}

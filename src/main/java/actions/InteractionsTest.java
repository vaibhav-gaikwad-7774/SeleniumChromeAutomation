package actions;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class InteractionsTest extends BaseTest{
	public static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

	@Test
    public void testSendKeys() {
        driver.get(URL);
        WebElement inputText = driver.findElement(By.name("my-text"));
        String textValue = "Hello World!";
        inputText.sendKeys(textValue);
        Assert.assertEquals(inputText.getDomProperty("value"), textValue);
        inputText.clear();
        Assert.assertEquals(inputText.getDomProperty("value"), "");
    }
}
package adAdvancedInteraction;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import actions.BaseTest;

public class ActionsTest extends BaseTest{
	String URL = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
	String URL1 = "https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html";
	String URL2 = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";
	String URL3 = "https://www.google.com";
	

    @Test
    public void testMouseHover() {
        driver.get(URL);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement compassImage = driver.findElement(By.xpath("//img[@src='img/compass.png']"));
        actions.moveToElement(compassImage).perform();

        WebElement caption = driver.findElement(By.xpath("//p[text()='Compass']"));
        assert caption.getText().equals("Compass");
    }
    @Test
    public void testCopyAndPaste() {
        driver.get(URL2);
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        WebElement textArea = driver.findElement(By.name("my-textarea"));

        actions.sendKeys(textInput, "Hello Tester")
            .keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c")
            .sendKeys(textArea, "v")
            .keyUp(Keys.CONTROL).perform();

        assert textInput.getDomAttribute("value").equals(textArea.getDomAttribute("value"));
    }
    
    @Test
    public void testGoogleSearchCopyPaste() {
        // Navigate to Google's homepage
        driver.get(URL3);
        driver.manage().window().maximize();

        // Initialize the Actions class
        Actions actions = new Actions(driver);

        // Locate the Google search input field
        WebElement searchInput = driver.findElement(By.name("q"));

        // Type a text into the Google search input field
        searchInput.sendKeys("Selenium Testing");

        // Simulate "Ctrl+A" (select all) and "Ctrl+C" (copy)
        actions.click(searchInput)
               .keyDown(Keys.CONTROL)
               .sendKeys("a")
               .sendKeys("c")
               .keyUp(Keys.CONTROL)
               .perform();

        // Navigate to a sample form site for the paste operation
        driver.get("https://www.w3schools.com/html/html_forms.asp");

        // Locate a text input field on the sample site
        WebElement sampleInput = driver.findElement(By.id("fname"));

        // Simulate "Ctrl+V" (paste) into the sample input field
        actions.click(sampleInput)
               .keyDown(Keys.CONTROL)
               .sendKeys("v")
               .keyUp(Keys.CONTROL)
               .perform();

        // Assert that the text was successfully pasted
        assert sampleInput.getAttribute("value").equals("Selenium Testing");
    }

    
    

}

package exceptions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import actions.BaseTest;

public class ExceptionsTestDemo extends BaseTest {

    @Test
    public void testNoSuchElementException() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement textInput = driver.findElement(By.id("my-text-id")); // Corrected locator
        textInput.sendKeys("Hello World");
    }

    @Test
    public void testNoSuchElementException2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        // Adding an implicit wait can help ensure elements are loaded
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement landscape = driver.findElement(By.cssSelector("img#landscape")); // Corrected locator
        String actualSrc = landscape.getDomAttribute("src");
        assertEquals(actualSrc.contains("landscape"), true, "The source does not contain 'landscape'");
    }

    @Test
    public void testElementNotInteractableException() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        WebElement hiddenElement = driver.findElement(By.cssSelector("input[type=hidden]")); // Correct locator

        // Handle it using try/catch blocks for graceful handling
        try {
            hiddenElement.click();
        } catch (Exception e) {
            System.out.println("Element is not interactable: " + e.getMessage());
        }
    }

    @Test
    public void testNoAlertPresentException() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html");

        driver.findElement(By.id("my-alert")).click(); // Corrected locator
        try {
            Alert alert = driver.switchTo().alert();
            assertEquals(alert.getText(), "Hello world!", "Alert text does not match");
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }

    @Test
    public void testNoSuchSessionException() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        driver.quit(); // Ending the session

        try {
            WebElement textInput = driver.findElement(By.id("my-text-id")); // Corrected locator
            textInput.sendKeys("Hello World");
        } catch (Exception e) {
            System.out.println("No session available: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidSelectorException() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        try {
            WebElement textInput = driver.findElement(By.xpath("//*[@id='my-text-id']")); // Corrected XPath
            textInput.sendKeys("Hello World");
        } catch (Exception e) {
            System.out.println("Invalid selector: " + e.getMessage());
        }
    }
//    @Test
//    public void testStaleElementReferenceException() {
//        // Navigate to the web form page
//        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
//
//        // Locate the "Return to index" link
//        WebElement returnToIndex = driver.findElement(By.linkText("Return to index"));
//        returnToIndex.click(); // Navigate to the index page
//
//        // Verify the URL contains "index.html"
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("index.html"), "URL does not contain 'index.html'");
//
//        // Navigate back to the form page
//        driver.navigate().back();
//
//        // Introduce a wait to ensure the page loads fully
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Return to index")));
//
//        // Re-locate and interact with the "Return to index" link
//        try {
//            returnToIndex = driver.findElement(By.linkText("Return to index"));
//            returnToIndex.click(); // Retry clicking the link
//        } catch (ElementClickInterceptedException e) {
//            System.out.println("Caught ElementClickInterceptedException. Attempting to resolve...");
//
//            // Scroll to make the element visible, if needed
//            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", returnToIndex);
//            returnToIndex.click(); // Retry clicking after scrolling
//        }
//
//        // Verify navigation after resolving the issue
//        currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("index.html"), "Navigation did not succeed.");
//    }


    
    


    }


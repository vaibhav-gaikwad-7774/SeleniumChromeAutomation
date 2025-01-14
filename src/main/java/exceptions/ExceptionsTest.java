package exceptions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;

import actions.BaseTest;

public class ExceptionsTest extends BaseTest {

    @Test
    public void testNoSuchElementException() {
        driver.get("https://www.google.com");
        try {
            // Intentional incorrect locator to trigger exception
            WebElement searchBox = driver.findElement(By.id("non-existent-id"));
            searchBox.sendKeys("Selenium WebDriver");
        } catch (WebDriverException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    @Test
    public void testNoSuchElementException2() {
        driver.get("https://www.google.com");
        try {
            // Correct locator with assertion
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
            assertEquals(searchBox.isDisplayed(), true, "Search box is not displayed");
        } catch (WebDriverException e) {
            System.out.println("Element not found: " + e.getMessage());
        }
    }

    @Test
    public void testElementNotInteractableException() {
        driver.get("https://www.google.com");
        try {
            // Simulating interaction with a hidden or disabled element
            WebElement hiddenElement = driver.findElement(By.cssSelector("input[aria-hidden='true']"));
            hiddenElement.click();
        } catch (WebDriverException e) {
            System.out.println("Element not interactable: " + e.getMessage());
        }
    }

    @Test
    public void testNoAlertPresentException() {
        driver.get("https://www.google.com");
        try {
            Alert alert = driver.switchTo().alert();
            assertEquals(alert.getText(), "Hello world!", "Alert text does not match");
            alert.accept();
        } catch (WebDriverException e) {
            System.out.println("No alert present: " + e.getMessage());
        }
    }

    @Test
    public void testNoSuchSessionException() {
        driver.get("https://www.google.com");
        driver.quit(); // Closing the session

        try {
            // Attempting to interact with an element after quitting the session
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");
        } catch (WebDriverException e) {
            System.out.println("No session available: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidSelectorException() {
        driver.get("https://www.google.com");
        try {
            // Using an invalid CSS selector to trigger exception
            WebElement searchBox = driver.findElement(By.cssSelector("#$invalid-selector"));
            searchBox.sendKeys("Selenium WebDriver");
        } catch (WebDriverException e) {
            System.out.println("Invalid selector: " + e.getMessage());
        }
    }

    @Test
    public void testStaleElementReferenceException() {
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        driver.navigate().refresh(); // Refreshing the page to invalidate the element reference

        try {
            // Attempting to interact with a stale element
            searchBox.sendKeys("Selenium WebDriver");
        } catch (WebDriverException e) {
            System.out.println("Stale element reference: " + e.getMessage());
        }
    }
}

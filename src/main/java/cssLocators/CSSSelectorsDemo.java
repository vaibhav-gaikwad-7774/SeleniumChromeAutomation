package cssLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import actions.BaseTest;

import java.util.List;

public class CSSSelectorsDemo extends BaseTest {

    public static final String DEMO_URL = "C:\\Users\\GFG0329\\eclipse-workspace\\SeleniumChromeAutomation\\src\\main\\java\\cssLocators\\demo-form.html";

    @Test
    public void testCSSSelectors() {
        // Open the demo page
        driver.get(DEMO_URL);

        // 1. **Element Selector** - Select an element by its tag name
        WebElement form = driver.findElement(By.cssSelector("form"));
        Assert.assertTrue(form.isDisplayed(), "Form is not displayed.");

        // 2. **ID Selector** - Select an element by its unique ID
        WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        Assert.assertTrue(usernameField.isEnabled(), "Username field is not enabled.");
        usernameField.sendKeys("TestUser");

        // 3. **Class Selector** - Select an element by its class name
        WebElement passwordField = driver.findElement(By.cssSelector(".password-input"));
        Assert.assertTrue(passwordField.isDisplayed(), "Password field is not displayed.");
        passwordField.sendKeys("Password123");

        // 4. **Universal Selector** - Select all elements in the DOM
        List<WebElement> allElements = driver.findElements(By.cssSelector("*"));
        Assert.assertFalse(allElements.isEmpty(), "No elements found on the page.");

        // 5. **Attribute Selector** - Select an element based on an attribute
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        Assert.assertTrue(emailField.isDisplayed(), "Email field is not displayed.");
        emailField.sendKeys("test@example.com");

        // 6. **Descendant Selector** - Select a child element inside a parent
        WebElement submitButton = driver.findElement(By.cssSelector("form button[type='submit']"));
        Assert.assertTrue(submitButton.isDisplayed(), "Submit button is not displayed.");

        // 7. **Child Selector** - Select a direct child element
        WebElement firstLabel = driver.findElement(By.cssSelector("form > label"));
        Assert.assertEquals(firstLabel.getText(), "Username:", "First label text does not match.");

        // 8. **Pseudo-Classes** - Select elements based on their state or position
        WebElement lastListItem = driver.findElement(By.cssSelector("ul li:last-child"));
        Assert.assertEquals(lastListItem.getText(), "Option 3", "Last list item text does not match.");

        WebElement firstListItem = driver.findElement(By.cssSelector("ul li:first-child"));
        Assert.assertEquals(firstListItem.getText(), "Option 1", "First list item text does not match.");

        // 9. **Combining Selectors** - Refine element selection using combined criteria
        WebElement dropdownOption = driver.findElement(By.cssSelector("select[name='options'] option[value='2']"));
        Assert.assertEquals(dropdownOption.getText(), "Option 2", "Dropdown option text does not match.");
        dropdownOption.click();

        // Submit the form
        submitButton.click();

        // Verify the success message
        WebElement successMessage = driver.findElement(By.cssSelector(".success-message"));
        Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed.");
        Assert.assertEquals(successMessage.getText(), "Form submitted successfully!", "Success message text does not match.");
    }
}

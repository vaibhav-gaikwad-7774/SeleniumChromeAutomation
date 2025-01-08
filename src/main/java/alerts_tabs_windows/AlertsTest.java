package alerts_tabs_windows;

import static org.testng.Assert.assertEquals; // Import TestNG's assertEquals

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import actions.BaseTest;

public class AlertsTest extends BaseTest {

    private static final String URL = "https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html";

    @Test
    public void testSimpleAlert() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement simpleAlertButton = driver.findElement(By.id("my-alert"));
        simpleAlertButton.click();

        Thread.sleep(2000); // Pause to see the alert before switching
        Alert alert = driver.switchTo().alert(); // mandatory step
        assertEquals(alert.getText(), "Hello world!");

        Thread.sleep(2000); // Pause to see the alert text before accepting
        alert.accept(); // clicks on OK button
    }

    @Test
    public void testConfirmationAlert() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement confirmationAlertButton = driver.findElement(By.id("my-confirm"));
        confirmationAlertButton.click();

        Thread.sleep(2000); // Pause to see the alert before switching
        Alert alert = driver.switchTo().alert(); // mandatory step
        assertEquals(alert.getText(), "Is this correct?");

        Thread.sleep(2000); // Pause before dismissing
        alert.dismiss(); // clicks on CANCEL button
        assertEquals(driver.findElement(By.id("confirm-text")).getText(), "You chose: false");

        Thread.sleep(2000); // Pause before triggering the alert again
        confirmationAlertButton.click();
        alert.accept(); // clicks on OK button
        assertEquals(driver.findElement(By.id("confirm-text")).getText(), "You chose: true");
    }

    @Test
    public void testPromptAlert() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement promptAlertButton = driver.findElement(By.id("my-prompt"));
        promptAlertButton.click();

        Thread.sleep(2000); // Pause to see the alert before switching
        Alert alert = driver.switchTo().alert(); // mandatory step
        assertEquals(alert.getText(), "Please enter your name");

        Thread.sleep(2000); // Pause before entering text
        String text = "Hello Tester!";
        alert.sendKeys(text);

        Thread.sleep(2000); // Pause to see the entered text before accepting
        alert.accept(); // clicks on OK button
        assertEquals(driver.findElement(By.id("prompt-text")).getText(), "You typed: " + text);
    }

    @Test
    public void testModal() throws InterruptedException {
        driver.get(URL);
        driver.manage().window().maximize();

        WebElement promptAlertButton = driver.findElement(By.id("my-modal"));
        promptAlertButton.click();


        // explicit wait for close button
        WebElement closeButton = driver.findElement(By.xpath("//button[text()='Close']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));

        Thread.sleep(2000); // Pause before clicking close
        closeButton.click();

        assertEquals(driver.findElement(By.id("modal-text")).getText(), "You chose: Close");
    }
}

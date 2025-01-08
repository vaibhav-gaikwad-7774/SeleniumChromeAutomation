package io.learn.windows;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import actions.BaseTest;

public class WindowHandlingTest extends BaseTest {

    @Test
    public void testNewTab() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String initialHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertEquals(driver.getWindowHandles().size(), 2, "The number of windows should be 2.");

        driver.switchTo().window(initialHandle);
        driver.close();
        assertEquals(driver.getWindowHandles().size(), 1, "The number of windows should be 1 after closing the initial window.");
    }

    @Test
    public void testNewWindow() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        String initialHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        assertEquals(driver.getWindowHandles().size(), 2, "The number of windows should be 2.");

        driver.switchTo().window(initialHandle);
        driver.close();
        assertEquals(driver.getWindowHandles().size(), 1, "The number of windows should be 1 after closing the initial window.");
    }

    @Test
    public void testContentInNewTab() {
        driver.get("https://the-internet.herokuapp.com/windows");
        String initialHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        assertEquals(windowHandles.size(), 2, "The number of windows should be 2 after clicking the link.");

        for (String handle : windowHandles) {
            if (!handle.equals(initialHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        assertEquals(driver.findElement(By.xpath("//h3")).getText(), "New Window", "The new window should display the text 'New Window'.");
        driver.switchTo().window(initialHandle);
        driver.close(); // Not working at the moment
        assertEquals(windowHandles.size(), 2, "The number of windows should be 2 after closing the initial window.");
    }
}

package seleniumpractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {
    public static void main(String[] args) {
        // Use WebDriverManager to set up ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and add flags
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--mute-audio"); // Mute audio
        options.addArguments("--autoplay-policy=no-user-gesture-required"); // Enable autoplay

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Output to console
        System.out.println("Chrome options set. Audio is muted successfully.");

        // Load a YouTube video from GeeksforGeeks
        driver.get("https://www.youtube.com/watch?v=vP5TkF0xJgI"); // A* Search Algorithm video

        // Wait for the page to load completely
        try {
            Thread.sleep(5000); // Adjust the wait time if necessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Use JavaScript to start video playback
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('video').play();");

        // Pause execution for observation
        try {
            Thread.sleep(10000); // Sleep for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}

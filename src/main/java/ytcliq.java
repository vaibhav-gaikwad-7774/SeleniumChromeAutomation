import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;

public class ytcliq {
    public static void main(String[] args) {
        // Automatically set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Open the uBlock Origin crx extension if needed
        File file = new File("./bin/ublockorigin.crx");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(file); // Load the extension if you want

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);
        
        // Open YouTube Music
        driver.get("https://music.youtube.com");

        // Maximize browser window
        driver.manage().window().maximize();

        try {
            // Wait for the page to load
            Thread.sleep(3000);

            // Locate the search box and search for the song
            WebElement searchBox = driver.findElement(By.xpath("//input[@id='input']"));
            searchBox.sendKeys("say goodbye"); // Replace with the desired song name
            searchBox.sendKeys(Keys.ENTER);

            // Wait for the results to load
            Thread.sleep(3000);

            // Click on the first result
            WebElement firstResult = driver.findElement(By.xpath("//div[@id='contents']/ytmusic-responsive-list-item-renderer[1]"));
            firstResult.findElement(By.xpath(".//a[@class='yt-simple-endpoint style-scope yt-formatted-string']")).click();

            // Wait for the song to load
            Thread.sleep(3000);

            // Find the length of the song
            WebElement player = driver.findElement(By.xpath("//ytmusic-player-bar/div[@id='left-controls']/span"));
            int totalSeconds = convertDurationToSeconds(player.getText().split("/ ")[1]);

            // Keep the browser open for the entire duration of the song
            Thread.sleep(totalSeconds * 1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the song finishes
            driver.quit();
        }
    }

    // Helper method to convert "mm:ss" or "hh:mm:ss" duration into total seconds
    private static int convertDurationToSeconds(String durationText) {
        String[] timeParts = durationText.split(":");
        int seconds = 0;
        if (timeParts.length == 2) {
            seconds += Integer.parseInt(timeParts[0]) * 60; // Minutes to seconds
            seconds += Integer.parseInt(timeParts[1]);      // Seconds
        } else if (timeParts.length == 3) {
            seconds += Integer.parseInt(timeParts[0]) * 3600; // Hours to seconds
            seconds += Integer.parseInt(timeParts[1]) * 60;   // Minutes to seconds
            seconds += Integer.parseInt(timeParts[2]);        // Seconds
        }
        return seconds;
    }
}

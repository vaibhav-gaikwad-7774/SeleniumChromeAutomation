package seleniumpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager

public class ActionsExample {
    public static void main(String[] args) {
        // Set up WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Initialize the ChromeDriver
        WebDriver driver = new ChromeDriver();
        
        // Open GeeksforGeeks website
        driver.get("https://www.geeksforgeeks.org/");

        // Locate a web element (example: search box)
        WebElement searchBox = driver.findElement(By.name("q"));
        
        // Create an Actions instance
        Actions actions = new Actions(driver);
        
        // Perform actions: Click on the search box and enter text
        actions.click(searchBox).sendKeys("Selenium").perform();
        
        // Optionally, you can submit the search
        actions.sendKeys(Keys.RETURN).perform();
        
        // Close the browser
        driver.quit();
    }
}

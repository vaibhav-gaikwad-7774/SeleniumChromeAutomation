package DomExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

public class DOMManipulationExample {
    public static void main(String[] args) {
        // Initialize WebDriver (assuming ChromeDriver is in the path)
        WebDriver driver = new ChromeDriver();
        
        // Open a sample page
        driver.get("C:\\Users\\GFG0329\\eclipse-workspace\\SeleniumChromeAutomation\\src\\main\\java\\DomExample\\index.html"); // Update path to the HTML file

        // Find the button and click it
        WebElement button = driver.findElement(By.id("changeButton"));
        button.click();

        // Find the heading element and change its text using JavaScript Executor
        WebElement heading = driver.findElement(By.id("heading"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText = 'Welcome to the DOM';", heading);

        // Validate if the text has been updated
        String updatedText = heading.getText();
        System.out.println("Updated Text: " + updatedText);

        // Close the browser
        driver.quit();
    }
}

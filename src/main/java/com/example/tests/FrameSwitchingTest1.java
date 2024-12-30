package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameSwitchingTest1 {
    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open the webpage with multiple iframes
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        // Perform actions in the default content
        WebElement headerElement = driver.findElement(By.className("title"));
        System.out.println("Text in the default content: " + headerElement.getText());

        // Switch to the first iframe
        driver.switchTo().frame("frm1");

        // Perform actions within the first iframe
        WebElement frame1Element = driver.findElement(By.xpath("//h1[@id='frm1']"));
        System.out.println("Text inside the first iframe: " + frame1Element.getText());

        // Switch to the nested iframe within the first iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frm2']")));  // Switch to the inner iframe by WebElement

        // Perform actions within the inner iframe
        WebElement innerFrameElement = driver.findElement(By.xpath("//h1[@id='frm3']"));
        System.out.println("Text inside the inner iframe: " + innerFrameElement.getText());

        // Switch back to the first iframe (parent frame)
        driver.switchTo().parentFrame(); // This switches back to the parent frame (first iframe)

        // Perform additional actions if needed within the first iframe (after returning from inner iframe)
        // For example, printing the title again or some other element
        System.out.println("Switched back to the first iframe");

        // Switch back to the default content
        driver.switchTo().defaultContent();

        // Perform actions again in the default content after switching back
        WebElement footerElement = driver.findElement(By.className("post-footer"));
        System.out.println("Text in the default content after switching back: " + footerElement.getText());

        // Close the browser
        driver.quit();
    }
}

package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {

    public static void main(String[] args) {

        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Creating instance of Chrome driver
        WebDriver driver = new ChromeDriver();

        try {
           // Launching URL
            driver.get("https://demoqa.com/select-menu");

            // Maximizing window
            driver.manage().window().maximize();

            //  Selecting the dropdown element by locating its id
            Select select = new Select(driver.findElement(By.id("oldSelectMenu")));

            // Selecting an option by its value
            System.out.println("Select the Option by value 6");
            select.selectByValue("6");
            System.out.println("Selected value is: " + select.getFirstSelectedOption().getText());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

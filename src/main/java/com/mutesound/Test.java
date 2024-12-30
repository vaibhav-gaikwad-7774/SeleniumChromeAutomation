package com.mutesound;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {
    public static void main(String[] args) {
        // Use WebDriverManager to set up ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Create ChromeOptions to customize ChromeDriver settings
        ChromeOptions op = new ChromeOptions();
        
        // Add correct argument to mute audio
        op.addArguments("--mute-audio");
        
        // Remove autoplay policy that requires user gesture
        op.addArguments("--autoplay-policy=no-user-gesture-required");

        // Initialize ChromeDriver with ChromeOptions
        ChromeDriver driver = new ChromeDriver(op);

        // Navigate to YouTube video
        driver.get("https://www.youtube.com/watch?v=3_x_Fb31NLE&list=PLqM7alHXFySEQDk2MDfbwEdjd2svVJH9p&autoplay=1");
        
        // Wait for 10 seconds before closing the browser
        try {
            Thread.sleep(10000); // Wait for 10 seconds (10,000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Quit the browser
        driver.quit();
    }
}

package com.example.tests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class CanvasToPNG {

    public static void main(String[] args) throws IOException {
        // Set up WebDriver (assuming you're using ChromeDriver)
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the page containing the canvas
            driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_canvas_tut_path2");

            // Locate the canvas element
            WebElement canvas = driver.findElement(By.id("myCanvas"));

            // Execute JavaScript to get the canvas content as a base64 PNG
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            String base64String = (String) jsExecutor.executeScript(
                    "var canvas = arguments[0];" +
                    "return canvas.toDataURL('image/png').substring(22);", canvas);

            // Decode the base64 string and save it as a PNG file
            byte[] imageBytes = Base64.getDecoder().decode(base64String);
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imageBytes));

            // Specify the file path where you want to save the image
            File outputfile = new File("canvas_image.png");
            ImageIO.write(image, "png", outputfile);

            System.out.println("Canvas image saved as PNG successfully.");
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

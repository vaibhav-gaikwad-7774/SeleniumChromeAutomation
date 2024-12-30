package com.example.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class ImageDownloadTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to Google Images
        driver.get("https://www.google.com/imghp?hl=en&authuser=0&ogbl");

        // Search for Supra images
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("supra");
        searchBox.submit();

        // Wait for images to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img")));

        // Locate and download the images
        List<WebElement> images = driver.findElements(By.xpath("//img[contains(@id,'dimg_')]"));
        Path imageDirectory = Paths.get("Downloads");
        int imageCounter = 1;

        for (int i = 0; i < Math.min(6, images.size()); i++) {
            try {
                WebElement image = images.get(i);
                String imageSrc = image.getAttribute("src");

                if (imageSrc != null && !imageSrc.isEmpty()) {
                    if (imageSrc.startsWith("data:image")) {
                        // Decode and save base64 image
                        String[] parts = imageSrc.split(",");
                        String base64String = parts[1];
                        byte[] imageBytes = Base64.getDecoder().decode(base64String);
                        Path outputPath = imageDirectory.resolve("image_" + imageCounter + ".jpg");

                        try (FileOutputStream fos = new FileOutputStream(outputPath.toFile())) {
                            fos.write(imageBytes);
                            System.out.println("Downloaded image " + imageCounter + " to " + outputPath.toString());
                        } catch (Exception e) {
                            System.out.println("Failed to download image " + imageCounter + ": " + e.getMessage());
                        }
                    } else {
                        // Handle image URL
                        URL imageUrl = new URL(imageSrc);
                        Path outputPath = imageDirectory.resolve("image_" + imageCounter + ".jpg");

                        try (InputStream in = imageUrl.openStream();
                             FileOutputStream out = new FileOutputStream(outputPath.toFile())) {
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            while ((bytesRead = in.read(buffer)) != -1) {
                                out.write(buffer, 0, bytesRead);
                            }
                            System.out.println("Downloaded image " + imageCounter + " to " + outputPath.toString());
                        } catch (Exception e) {
                            System.out.println("Failed to download image " + imageCounter + ": " + e.getMessage());
                        }
                    }
                    imageCounter++;
                }
            } catch (Exception e) {
                System.out.println("Error processing image " + (i + 1) + ": " + e.getMessage());
            }
        }

        // Close the browser
        driver.quit();
    }
}

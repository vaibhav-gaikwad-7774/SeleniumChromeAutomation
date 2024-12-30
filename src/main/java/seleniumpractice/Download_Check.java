
//        File fileLocation = new File("D:\\gfg329\\article Images");


package seleniumpractice;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_Check {
    public static void main(String[] args) throws InterruptedException {
        // Using WebDriverManager to manage the ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://the-internet.herokuapp.com/download");

        // Locate and click on the download link
        WebElement downloadLink = driver.findElement(By.linkText("LambdaTest.txt"));
        downloadLink.click();

        // Wait for the file to download
        Thread.sleep(5000);  // Increased sleep time to allow download to complete

        // Specify the file download directory
        File fileLocation = new File("C:\\Users\\GFG0329\\Downloads");

        // Get the list of files in the directory
        File[] totalFiles = fileLocation.listFiles();

        // Check if the directory exists and contains files
        boolean fileFound = false;
        if (totalFiles != null) {
            // Traverse through the files to find the downloaded file
            for (File file : totalFiles) {
                if (file.getName().equals("LambdaTest.txt")) {
                    fileFound = true;
                    System.out.println("Success: 'LambdaTest.txt' has been downloaded successfully.");
                    break;
                }
            }

            // If the file was not found, show an appropriate message
            if (!fileFound) {
                System.out.println("Error: 'LambdaTest.txt' was not found in the directory.");
            }
        } else {
            System.out.println("Error: The directory 'D:\\gfg329\\article Images' is empty or not found.");
        }

        // Close the browser
        driver.quit();
    }
}

package seleniumpractice;
import io.github.bonigarcia.wdm.WebDriverManager; // Import WebDriverManager
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SeleniumTestwww {
    public static void main(String[] args) {
        // Setup WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();  // Automatically set up the ChromeDriver

        // Configure Chrome to download files automatically and disable PDF viewer
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", "C:\\Users\\hp\\Desktop");  // Set your download directory
        prefs.put("download.prompt_for_download", false);  // Disable download prompt
        prefs.put("download.directory_upgrade", true);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("plugins.always_open_pdf_externally", true);  // Disable PDF opening in browser, force download

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Initialize WebDriver with ChromeOptions
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the webpage with the download link
        driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");

        // Handle popup manually or through automation (if necessary)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            // Close any popups if they appear
            WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            popupWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(), 'Close')]"))).click();
        } catch (Exception e) {
            System.out.println("No popup found or failed to close it.");
        }

        // Wait until the download link is clickable and click it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://file-examples.com/wp-content/storage/2017/10/file-example_PDF_500_kB.pdf']"))).click();

        // Wait for the file download to start
        try {
            Thread.sleep(10000);  // Wait to ensure the download completes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}

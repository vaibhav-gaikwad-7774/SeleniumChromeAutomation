package seleniumpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Scanner;

public class SimpleYouTubePlayer {

    public static void main(String[] args) {
        // Setup WebDriverManager to manage ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();  // Initialize ChromeDriver

        // Ask the user to enter the song they want to play
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the song or artist you want to play: ");
        String musicName = scanner.nextLine();

        // Open YouTube and search for the song
        driver.get("https://www.youtube.com/results?search_query=" + musicName);

        // Click on the first video from the search results
        WebElement firstVideo = driver.findElement(By.xpath("(//a[@id='video-title'])[1]"));
        firstVideo.click();  // Play the first video

        // Inform the user
        System.out.println("Playing: " + musicName);

        // Allow the video to play for a while (10 seconds)
        try {
            Thread.sleep(10000);  // Adjust this duration as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser after playing
        driver.quit();
        scanner.close();  // Close the scanner
    }
}

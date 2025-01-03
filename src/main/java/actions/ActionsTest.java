package actions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsTest extends baseTest {

    WebDriver driver;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testContextAndDoubleClick() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");

        Actions actions = new Actions(driver);

        WebElement dropDown2 = driver.findElement(By.id("my-dropdown-2"));
        actions.contextClick(dropDown2).perform();

        Thread.sleep(3000);  // Wait for the context menu to appear

        WebElement contextMenu2 = driver.findElement(By.id("context-menu-2"));
        Assert.assertTrue(contextMenu2.isDisplayed());

        WebElement dropDown3 = driver.findElement(By.id("my-dropdown-3"));
        actions.doubleClick(dropDown3).build().perform();
        WebElement contextMenu3 = driver.findElement(By.id("context-menu-3"));
        Assert.assertTrue(contextMenu3.isDisplayed());
           
    }
    
    @Test
    public void testMouseHover() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement compassImage = driver.findElement(By.xpath("/html/body/main/div/div[4]/div[1]/img"));
        actions.moveToElement(compassImage).build().perform();
        Thread.sleep(3000);

        WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("p")).near(compassImage));
        Assert.assertEquals(caption.getText(), "Compass");
    }
    
    @Test
    public void testMouseHover1() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        List<String> imageList = Arrays.asList("Compass", "Calendar", "Award", "Landscape");

        for (String imageName : imageList) {
            String locator = String.format("//img[@src='img/%s.png']", imageName.toLowerCase());
            WebElement image = driver.findElement(By.xpath(locator));
            actions.moveToElement(image).build().perform();

            WebElement caption = driver.findElement(RelativeLocator.with(By.tagName("p")).near(image));
            Assert.assertEquals(caption.getText(), imageName);  
        }
    }
    
    @Test
    public void testDragAndDrop() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));

        int offset = 100;
        Point initialLocation = draggable.getLocation();

        actions.dragAndDropBy(draggable, offset, 0).perform();
        Thread.sleep(1000);

        actions.dragAndDropBy(draggable, 0, offset).perform();
        Thread.sleep(1000);

        actions.dragAndDropBy(draggable, -offset, 0).perform();
        Thread.sleep(1000);

        actions.dragAndDropBy(draggable, 0, -offset).perform();
        Thread.sleep(1000);
        
        Point finalLocation = draggable.getLocation();
        Assert.assertEquals(initialLocation, finalLocation);
        
    }
    
    
    @Test
    public void testDragAndDrop2() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/drag-and-drop.html");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("target"));

        actions.dragAndDrop(source, target).build().perform();
        Point finalLocation = source.getLocation();

        
        
        Assert.assertEquals(finalLocation, target.getLocation());
        
    }
    
    @Test
    public void testClickAndHoldWithDelay() throws InterruptedException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/draw-in-canvas.html");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement canvas = driver.findElement(By.id("my-canvas"));
        actions.moveToElement(canvas).clickAndHold();

        int numPoints = 10;
        int radius = 8;

        for (int i = 0; i <= numPoints; i++) {
            double angle = Math.toRadians((double) (360 * i) / numPoints);
            double x = Math.sin(angle) * radius;
            double y = Math.cos(angle) * radius;

            actions.moveByOffset((int) x, (int) y).perform();
            Thread.sleep(500); // Pause for visibility
        }

        actions.release(canvas).build().perform();
    }

    	
    @Test
    public void testCopyAndPaste() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        WebElement textInput = driver.findElement(By.id("my-text-id"));
        WebElement textArea = driver.findElement(By.name("my-textarea"));

        actions.sendKeys(textInput, "Hello Tester").keyDown(Keys.CONTROL)
                .sendKeys(textInput, "a").sendKeys(textInput, "c")
                .sendKeys(textArea, "v").keyUp(Keys.CONTROL).build().perform();
        
//        Assert.assertEquals(textInput, (textArea.getDomAttribute("value")));

//        assertThat(textInput.getDomAttribute("value")).isEqualTo(textArea.getDomAttribute("value"));
    }
    
    
    
    
    


    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

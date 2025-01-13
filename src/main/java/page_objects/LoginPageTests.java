package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginPageTests {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/login-form.html");
    }

    @Test
    public void testLoginWithNormalApproach() {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("user");

        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();

        String loginSuccessText = driver.findElement(By.id("success")).getText();
        // Replacing assertThat with assertEquals
        assertEquals(loginSuccessText, "Login successful", "Login failed with correct credentials");
    }

    @Test
    public void testValidLoginWithPageObjectApproach() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "user");
        // Replacing assertThat with assertEquals
        assertEquals(loginPage.isLoginSuccessful(), true, "Login should be successful with correct credentials");
    }

    @Test
    public void testInvalidLoginWithPageObjectApproach() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user11", "user111");
        // Replacing assertThat with assertEquals
        assertEquals(loginPage.isErrorDisplayed(), true, "Error message should be displayed for invalid login");
    }

    @Test
    public void testValidLoginWithPageFactoryApproach() {
        LoginPageWithPageFactory loginPage = new LoginPageWithPageFactory(driver);
        loginPage.login("user", "user");
        // Replacing assertThat with assertEquals
        assertEquals(loginPage.isLoginSuccessful(), true, "Login should be successful with correct credentials");
    }

    @Test
    public void testInvalidLoginWithPageFactoryApproach() {
        LoginPageWithPageFactory loginPage = new LoginPageWithPageFactory(driver);
        loginPage.login("user11", "user111");
        // Replacing assertThat with assertEquals
        assertEquals(loginPage.isErrorDisplayed(), true, "Error message should be displayed for invalid login");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}



package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object class
public class LoginPage {

    private WebDriver driver;

    // Locators
    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By submitButton = By.cssSelector("button");
    By successMessage = By.id("success");
    By errorMessage = By.id("invalid");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void login(String userName, String password) {
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickLogin();
    }

    public boolean isLoginSuccessful() {
        return driver.findElement(successMessage).isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    private void enterUserName(String userName) {
        driver.findElement(usernameInput).sendKeys(userName);
    }

    private void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    private void clickLogin() {
        driver.findElement(submitButton).click();
    }
}


package page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// Page Object class
public class LoginPageWithPageFactory {

    // Locators
    @FindBy(id = "username")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(css = "button")
    WebElement submitButton;

    @FindBy(id = "success")
    WebElement successMessage;

    @FindBy(id = "invalid")
    WebElement errorMessage;

    // Constructor
    public LoginPageWithPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void login(String userName, String password) {
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickLogin();
    }

    public boolean isLoginSuccessful() {
        return successMessage.isDisplayed();
    }

    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }

    private void enterUserName(String userName) {
        usernameInput.sendKeys(userName);
    }

    private void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    private void clickLogin() {
        submitButton.click();
    }
}




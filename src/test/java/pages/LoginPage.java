package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    // Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    private By loginLogo = By.className("login_logo");

    public LoginPage(WebDriver driver) {
        super(driver);
        LoggerUtility.infoLog("LoginPage initialized");
    }

    public void enterUsername(String username) {
        LoggerUtility.infoLog("Entering username: " + username);
        elementHelper.sendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        LoggerUtility.infoLog("Entering password");
        elementHelper.sendKeys(passwordField, password);
    }

    public void clickLogin() {
        LoggerUtility.infoLog("Clicking login button");
        elementHelper.click(loginButton);
    }

    public void login(String username, String password) {
        LoggerUtility.infoLog("Performing login with username: " + username);
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        LoggerUtility.infoLog("Login submitted");
    }

    public String getErrorMessage() {
        String error = elementHelper.getText(errorMessage);
        LoggerUtility.infoLog("Error message displayed: " + error);
        return error;
    }

    public boolean isLogoDisplayed() {
        boolean displayed = elementHelper.isDisplayed(loginLogo);
        LoggerUtility.infoLog("Login logo displayed: " + displayed);
        return displayed;
    }
}
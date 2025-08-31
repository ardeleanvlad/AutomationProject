package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    // Locators
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");
    private By backHomeButton = By.id("back-to-products");
    private By checkoutTitle = By.className("title");
    private By confirmationMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        super(driver);
        LoggerUtility.infoLog("CheckoutPage initialized");
    }

    public void enterFirstName(String firstName) {
        LoggerUtility.infoLog("Entering first name: " + firstName);
        elementHelper.sendKeys(firstNameField, firstName);
    }


    public void enterLastName(String lastName) {
        LoggerUtility.infoLog("Entering last name: " + lastName);
        elementHelper.sendKeys(lastNameField, lastName);
    }

    public void enterPostalCode(String postalCode) {
        LoggerUtility.infoLog("Entering postal code: " + postalCode);
        elementHelper.sendKeys(postalCodeField, postalCode);
    }

    public void clickContinue() {
        LoggerUtility.infoLog("Clicking Continue button");
        elementHelper.click(continueButton);
        LoggerUtility.infoLog("Clicked Continue button");
    }

    public void clickCancel() {
        LoggerUtility.infoLog("Clicking Cancel button");
        elementHelper.click(cancelButton);
        LoggerUtility.infoLog("Clicked Cancel button");
    }

    public void clickFinish() {
        LoggerUtility.infoLog("Clicking Finish button");
        elementHelper.click(finishButton);
        LoggerUtility.infoLog("Clicked Finish button");
    }

    public void clickBackHome() {
        LoggerUtility.infoLog("Clicking Back Home button");
        elementHelper.click(backHomeButton);
        LoggerUtility.infoLog("Clicked Back Home button");
    }

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        LoggerUtility.infoLog("Filling checkout form with firstName: " + firstName + ", lastName: " + lastName + ", postalCode: " + postalCode);
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public String getConfirmationMessage() {
        return elementHelper.getText(confirmationMessage);
    }

    public void validateOrderConfirmation() {
        String confirmationMessage = getConfirmationMessage();
        LoggerUtility.infoLog("Validating order confirmation message: " + confirmationMessage);
        Assert.assertEquals(confirmationMessage, "Thank you for your order!", "Order confirmation message mismatch!");
    }
}
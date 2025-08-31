package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private By cartTitle = By.className("title");
    private By cartItem = By.className("cart_item");
    private By checkoutButton = By.id("checkout");
    private By continueShoppingButton = By.id("continue-shopping");
    private By removeButton = By.xpath("//button[contains(@class, 'cart_button')]");
    private By itemName = By.className("inventory_item_name");
    private By itemPrice = By.className("inventory_item_price");

    public CartPage(WebDriver driver) {
        super(driver);
        LoggerUtility.infoLog("CartPage initialized");
    }

    public void clickCheckout() {
        LoggerUtility.infoLog("Clicking on Checkout button");
        elementHelper.click(checkoutButton);
        LoggerUtility.infoLog("Clicked on Checkout button");
    }

    public void clickContinueShopping() {
        elementHelper.click(continueShoppingButton);
        LoggerUtility.infoLog("Clicked on Continue Shopping button");
    }

    public void removeItem() {
        elementHelper.click(removeButton);
        LoggerUtility.infoLog("Item removed from cart");
    }

    public void viewCartDetails() {
        LoggerUtility.infoLog("Viewing cart details");
        elementHelper.waitForElementToBeVisible(cartTitle);
        boolean displayed = elementHelper.isDisplayed(cartItem);
        LoggerUtility.infoLog("Cart item displayed: " + displayed);
    }

    public String getItemName() {
        String name = elementHelper.getText(itemName);
        LoggerUtility.infoLog("Getting item name: " + name);
        return name;
    }

    public String getItemPrice() {
        String price = elementHelper.getText(itemPrice);
        LoggerUtility.infoLog("Getting item price: " + price);
        return price;
    }
}
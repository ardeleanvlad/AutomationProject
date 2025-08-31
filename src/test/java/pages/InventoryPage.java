package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {
    private By inventoryTitle = By.className("title");
    private By sortDropdown = By.className("product_sort_container");
    private By cartIcon = By.className("shopping_cart_link");
    private By addToCartButton = By.xpath("//button[text()='Add to cart'][1]");
    private By removeButton = By.xpath("//button[contains(text(), 'Remove')]");
    private By productItem = By.className("inventory_item");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");
    private By burgerMenu = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
        LoggerUtility.infoLog("InventoryPage initialized");
    }

    public void addItemToCart() {
        LoggerUtility.infoLog("Adding item to cart");
        elementHelper.click(addToCartButton);
        LoggerUtility.infoLog("Item added to cart");
    }

    public void removeItemFromCart() {
        LoggerUtility.infoLog("Removing item from cart");
        elementHelper.click(removeButton);
        LoggerUtility.infoLog("Item removed from cart");
    }

    public void clickCart() {
        LoggerUtility.infoLog("Clicking on Cart icon");
        elementHelper.click(cartIcon);
        LoggerUtility.infoLog("Clicked on Cart icon");
    }

    public void sortProducts(String sortOption) {
        LoggerUtility.infoLog("Sorting products by option: " + sortOption);
        elementHelper.selectFromDropdown(sortDropdown, sortOption);
        LoggerUtility.infoLog("Products sorted by: " + sortOption);
    }

    public void viewProductDetails() {
        LoggerUtility.infoLog("Viewing product details");
        elementHelper.isDisplayed(productItem);
        String name = elementHelper.getText(productName);
        String price = elementHelper.getText(productPrice);
        LoggerUtility.infoLog("Product name: " + name + ", price: " + price);
    }

    public void openBurgerMenu() {
        LoggerUtility.infoLog("Opening burger menu");
        elementHelper.click(burgerMenu);
        LoggerUtility.infoLog("Burger menu opened");
    }

    public void logout() {
        LoggerUtility.infoLog("Logging out");
        elementHelper.click(logoutLink);
        LoggerUtility.infoLog("Logged out");
    }

    public String getPageTitle() {
        String title = elementHelper.getText(inventoryTitle);
        LoggerUtility.infoLog("Inventory page title: " + title);
        return title;
    }
}
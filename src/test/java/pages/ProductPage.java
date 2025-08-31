package pages;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By productName = By.className("inventory_details_name");
    private By productDescription = By.className("inventory_details_desc");
    private By productPrice = By.className("inventory_details_price");
    private By addToCartButton = By.xpath("//button[contains(text(), 'Add to cart')]");
    private By removeButton = By.xpath("//button[contains(text(), 'Remove')]");
    private By backButton = By.id("back-to-products");
    private By productImage = By.className("inventory_details_img");

    public ProductPage(WebDriver driver) {
        super(driver);
        LoggerUtility.infoLog("ProductPage initialized");
    }

    public void addToCart() {
        LoggerUtility.infoLog("Clicking 'Add to Cart' button");
        elementHelper.click(addToCartButton);
    }

    public void removeFromCart() {
        LoggerUtility.infoLog("Clicking 'Remove from Cart' button");
        elementHelper.click(removeButton);
    }

    public void goBack() {
        LoggerUtility.infoLog("Clicking 'Back to Products' button");
        elementHelper.click(backButton);
    }

    public void viewProductDetails() {
        LoggerUtility.infoLog("Viewing product details");
        String name = elementHelper.getText(productName);
        String desc = elementHelper.getText(productDescription);
        String price = elementHelper.getText(productPrice);
        boolean imageDisplayed = elementHelper.isDisplayed(productImage);
        LoggerUtility.infoLog("Product Name: " + name);
        LoggerUtility.infoLog("Product Description: " + desc);
        LoggerUtility.infoLog("Product Price: " + price);
        LoggerUtility.infoLog("Product Image displayed: " + imageDisplayed);
    }

    public String getProductName() {
        String name = elementHelper.getText(productName);
        LoggerUtility.infoLog("Getting product name: " + name);
        return name;
    }

    public String getProductPrice() {
        String price = elementHelper.getText(productPrice);
        LoggerUtility.infoLog("Getting product price: " + price);
        return price;
    }
}

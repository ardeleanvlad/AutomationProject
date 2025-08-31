package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import sharedData.SharedData;
import suite.Suite;

public class AddToCartTest extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE, Suite.SANITY_SUITE, Suite.ADDTOCART_SUITE})
    public void AddToCartTestMethod() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.viewProductDetails();
        inventoryPage.addItemToCart();
        inventoryPage.clickCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.viewCartDetails();
        cartPage.getItemName();
        cartPage.getItemPrice();
    }
}
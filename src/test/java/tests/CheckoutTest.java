package tests;

import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import sharedData.SharedData;
import suite.Suite;

public class CheckoutTest extends SharedData {

    @Test(groups = {Suite.REGRESSION_SUITE, Suite.SANITY_SUITE, Suite.CHECKOUT_SUITE})
    public void CheckoutTestMethod() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.addItemToCart();
        inventoryPage.clickCart();

        CartPage cartPage = new CartPage(getDriver());
        cartPage.clickCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.fillCheckoutForm("John", "Doe", "12345");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();

        checkoutPage.validateOrderConfirmation();
    }
}
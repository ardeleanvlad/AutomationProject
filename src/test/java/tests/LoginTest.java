package tests;

import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import sharedData.SharedData;
import suite.Suite;

public class LoginTest extends SharedData {


    @Test(groups = {Suite.REGRESSION_SUITE, Suite.SANITY_SUITE, Suite.LOGIN_SUITE})
    public void LoginTestMethod() {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.isLogoDisplayed();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        InventoryPage inventoryPage = new InventoryPage(getDriver());
        inventoryPage.getPageTitle();
        inventoryPage.openBurgerMenu();
        inventoryPage.logout();
    }
}
package pages;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver;
    public ElementHelper elementHelper;
    public PageHelper pageHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        pageHelper = new PageHelper(driver);
        PageFactory.initElements(driver, this);
    }
}
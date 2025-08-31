package helperMethods;

import org.openqa.selenium.WebDriver;

public class PageHelper {
    private WebDriver driver;

    public PageHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
}
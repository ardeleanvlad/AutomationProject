package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowser implements BrowserInterface {
    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void openBrowser() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        driver = new EdgeDriver(options);
    }

    @Override
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Override
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }
}

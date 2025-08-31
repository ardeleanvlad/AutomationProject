package sharedData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.Map;

public class ChromeBrowser implements BrowserInterface {
    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--incognito");
        options.addArguments("--disable-password-manager-reauthentication");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false
        ));
        driver = new ChromeDriver(options);
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

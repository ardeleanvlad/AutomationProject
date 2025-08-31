package sharedData;

import org.openqa.selenium.WebDriver;

public interface BrowserInterface {
    WebDriver getDriver();
    void openBrowser();
    void closeBrowser();
    void maximizeWindow();
}
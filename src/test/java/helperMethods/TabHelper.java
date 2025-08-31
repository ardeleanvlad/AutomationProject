package helperMethods;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class TabHelper {
    private WebDriver driver;

    public TabHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTab(int tabIndex) {
        Set<String> windowHandles = driver.getWindowHandles();
        String[] handles = windowHandles.toArray(new String[0]);
        if (tabIndex < handles.length) {
            driver.switchTo().window(handles[tabIndex]);
        }
    }

    public void closeCurrentTab() {
        driver.close();
    }

    public void openNewTab() {
        driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
    }
}
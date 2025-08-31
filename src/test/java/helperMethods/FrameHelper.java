package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class FrameHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public FrameHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void switchToFrame(String frameId) {
        driver.switchTo().frame(frameId);
    }

    public void switchToFrame(int frameIndex) {
        driver.switchTo().frame(frameIndex);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
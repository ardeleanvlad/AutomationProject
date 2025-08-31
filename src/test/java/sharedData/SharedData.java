package sharedData;

import helperMethods.ElementHelper;
import helperMethods.PageHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    private WebDriver driver;
    private BrowserInterface browserInterface;
    private ElementHelper elementHelper;
    private PageHelper pageHelper;
    private final String url = "https://www.saucedemo.com/";

    @BeforeMethod(alwaysRun = true)
    public void prepareEnvironment() {
        LoggerUtility.startTest(this.getClass().getSimpleName());

        String browser = System.getProperty("browser", "Chrome");

        switch (browser) {
            case "Chrome":
                browserInterface = new ChromeBrowser();
                break;
            case "Edge":
                browserInterface = new EdgeBrowser();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        browserInterface.openBrowser();
        driver = browserInterface.getDriver();
        browserInterface.maximizeWindow();

        elementHelper = new ElementHelper(driver);
        pageHelper = new PageHelper(driver);
        pageHelper.navigateToUrl(url);

        LoggerUtility.infoLog("The browser " + browser + " was opened and navigated successfully.");
    }

    @AfterMethod(alwaysRun = true)
    public void clearEnvironment(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }

        browserInterface.closeBrowser();
        LoggerUtility.infoLog("The browser was closed successfully.");
        LoggerUtility.finishTest(this.getClass().getSimpleName());
    }

    public WebDriver getDriver() {
        return driver;
    }
}

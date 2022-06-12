package main.java.pageMethods;

import main.java.utils.manageDriver.DriverFactory;
import main.java.utils.manageDriver.DriverManager;
import org.openqa.selenium.WebDriver;

public class TestBase {

    public static WebDriver driver;

    /**
     * Web driver to initiate the browser for the execution
     */
    public static void startBrowser() {
        DriverManager driverManager = DriverFactory.getDriverManager(System.getProperty("browser"));
        driver = driverManager.getDriver();
        driverManager.maximizeBrowser();
    }
}

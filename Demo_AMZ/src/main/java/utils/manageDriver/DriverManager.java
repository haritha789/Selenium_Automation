package main.java.utils.manageDriver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected static WebDriver driver;

    protected abstract void initDriver();

    public WebDriver getDriver() {
        initDriver();
        return driver;
    }

    public void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    public static void quitBrowser(){
        driver.quit();
    }

}

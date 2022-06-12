package main.java.utils.manageDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class FirefoxManager extends DriverManager {

    @Override
    protected void initDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.setCapability("browserName", "firefox");
        options.setCapability("acceptSslCerts", "true");
        options.setCapability("javascriptEnabled", "true");
        DesiredCapabilities cap = DesiredCapabilities.firefox();
        options.merge(cap);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
    
package main.java.utils.manageDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class ChromeManager extends DriverManager {

    @Override
    protected void initDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setCapability(ChromeOptions.CAPABILITY, options);
        options.setCapability("browserName", "chrome");
        options.setCapability("acceptSslCerts", "true");
        options.setCapability("javascriptEnabled", "true");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        options.merge(cap);
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (Exception e) {
            driver = new ChromeDriver();
        }
    }

}

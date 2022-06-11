package main.java.utils.manageDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxManager extends DriverManager {

    @Override
    protected void initDriver() {
        driver = new FirefoxDriver();
    }
}

package main.java.utils.manageDriver;

import org.openqa.selenium.safari.SafariDriver;

public class SafariManager extends DriverManager {

    @Override
    protected void initDriver() {
        driver = new SafariDriver();
    }
}

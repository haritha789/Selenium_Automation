package main.java.utils.manageDriver;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeManager extends DriverManager {

    @Override
    protected void initDriver() {
        System.setProperty("webdriver.chrome.driver", "test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

}

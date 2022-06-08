package main.java.pageMethods;

import main.java.utils.FindElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class    HomePage {

    private static WebDriver driver;


    public static void launchApplication(String url){
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
    }

    public static void clickOnHamburger(String locator){
        WebElement element = FindElements.findByCss(driver,locator);
        element.click();
    }
    public static void selectCategory(String locator){

    }


}

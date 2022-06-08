package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElements {

    public static WebElement findByCss(WebDriver driver,String locator){
        return driver.findElement(By.cssSelector(locator));
    }

    public static WebElement findByXpath(WebDriver driver,String locator){
       return driver.findElement(By.xpath(locator));
    }
}

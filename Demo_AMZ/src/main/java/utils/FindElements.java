package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {

    public static WebElement findByCss(WebDriver driver,String locator){
        return driver.findElement(By.cssSelector(locator));
    }

    public static WebElement findElementByXpath(WebDriver driver, String locator){
       return driver.findElement(By.xpath(locator));
    }

    public static List<WebElement> findElementsByXpath(WebDriver driver, String locator){
        return driver.findElements(By.xpath(locator));
    }
}

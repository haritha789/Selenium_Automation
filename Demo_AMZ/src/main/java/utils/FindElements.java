package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {

    /**
     * Used to find the element using the css as selector
     *
     * @param driver
     * @param locator
     * @return
     */

    public static WebElement findByCss(WebDriver driver, String locator) {
        return driver.findElement(By.cssSelector(locator));
    }

    /**
     * Used to find the element using the xpath as selector
     *
     * @param driver
     * @param locator
     * @return
     */
    public static WebElement findElementByXpath(WebDriver driver, String locator) {
        return driver.findElement(By.xpath(locator));
    }

    /**
     * Used to find the elements using the xpath as selector
     *
     * @param driver
     * @param locator
     * @return
     */

    public static List<WebElement> findElementsByXpath(WebDriver driver, String locator) {
        return driver.findElements(By.xpath(locator));
    }
}

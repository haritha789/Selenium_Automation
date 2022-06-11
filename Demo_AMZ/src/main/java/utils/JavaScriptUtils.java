package main.java.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    /**
     * To scroll the page to element based on the provided pixel
     *
     * @param driver
     * @param locator
     * @param locatorType
     * @return
     */
    public static WebElement scrollTheViewForElement(WebDriver driver, String locator, String locatorType) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = null;
        try {
            element = getElementBasedOnLocatorType(driver, locator, locatorType);
        } catch (Exception e) {

            jse.executeScript("scroll(0, 1000);");
        }
        while (element == null) {
            try {
                element = getElementBasedOnLocatorType(driver, locator, locatorType);
            } catch (Exception e) {
            }
            jse.executeScript("scroll(0, 250);");
        }
        return element;
    }

    /**
     * Get the element details based on the locator Type
     *
     * @param driver
     * @param locator
     * @param locatorType
     * @return
     */
    private static WebElement getElementBasedOnLocatorType(WebDriver driver, String locator, String locatorType) {
        WebElement element = null;
        if (locatorType.equalsIgnoreCase("CSS")) {
            element = FindElements.findByCss(driver, locator);
            return element;
        } else if (locatorType.equalsIgnoreCase("XPATH")) {
            element = FindElements.findElementByXpath(driver, locator);
            return element;
        }
        return element;
    }
}

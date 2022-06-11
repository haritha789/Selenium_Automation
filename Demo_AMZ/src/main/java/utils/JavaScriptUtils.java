package main.java.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {


    public static WebElement scrollToPixelViewforElement(WebDriver driver, String locator, String locatorType){
    JavascriptExecutor jse = (JavascriptExecutor)driver;
    WebElement element = null;
       try {
        element = validateTheLocatorPath(driver,locator,locatorType);
    }catch (Exception e){

        jse.executeScript("scroll(0, 1000);");
    }
        while(element==null) {
        try {
            element = validateTheLocatorPath(driver,locator,locatorType);
        }catch (Exception e){
        }
        jse.executeScript("scroll(0, 250);");
    }
        return element;
    }

    private static WebElement validateTheLocatorPath(WebDriver driver, String locator, String locatorType){
        WebElement element = null;
        if(locatorType.equalsIgnoreCase("CSS")){
           element=FindElements.findByCss(driver,locator);
           return element;
        }else if(locatorType.equalsIgnoreCase("XPATH")) {
            element = FindElements.findElementByXpath(driver, locator);
            return element;
        }
        return element;
    }
}

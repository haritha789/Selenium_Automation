package main.java.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

    public static WebElement clickElement(WebDriver driver,WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement element = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        return element;
       }

       public static String getElementText(WebElement webElement){
        return webElement.getText();
       }
}

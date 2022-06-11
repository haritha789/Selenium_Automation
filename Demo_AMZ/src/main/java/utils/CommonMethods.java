package main.java.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    public static WebElement clickElement(WebDriver driver,WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        return element;
       }

    public static void switchToSecondWindowTab(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
}

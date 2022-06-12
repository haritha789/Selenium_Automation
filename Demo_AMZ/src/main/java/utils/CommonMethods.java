package main.java.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CommonMethods {

    /**
     * Performs click on an web element
     *
     * @param driver
     * @param webElement
     * @return
     */

    public static WebElement clickElement(WebDriver driver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(webElement));
        element.click();
        return element;
    }

    /**
     * Validates the switching to second window tab
     *
     * @param driver
     */
    public static void switchToSecondWindowTab(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        long uiWaitStart = System.currentTimeMillis();
        long uiEndWait = uiWaitStart + 1000;
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            uiWaitStart = System.currentTimeMillis();
            if(uiWaitStart>uiEndWait){
                break;
            }
        }
    }
}

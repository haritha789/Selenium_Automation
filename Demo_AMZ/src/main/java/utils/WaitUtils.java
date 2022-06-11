package main.java.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    /**
     * Explicitly wait for the element to be visible
     *
     * @param driver
     * @param locator
     * @return
     */

    public static WebElement explicitWaitForElement(WebDriver driver, String locator) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#a-autoid-0-announce")));
        return element;
    }

    /**
     * Waits for the UI to complete the loading
     */
    public static void waitForUiLoading() {
        long uiWaitStart = System.currentTimeMillis();
        long uiEndWait = uiWaitStart + 400;
        while (uiWaitStart < uiEndWait) {
            uiWaitStart = System.currentTimeMillis();
        }

    }
}

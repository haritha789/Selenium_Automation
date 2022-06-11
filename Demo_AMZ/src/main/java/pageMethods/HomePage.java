package main.java.pageMethods;

import main.java.dataProvider.PropertiesReader;
import main.java.utils.CommonMethods;
import main.java.utils.FindElements;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class HomePage extends TestBase {

    /**
     * Used to Launch the Application URL in Browser
     */
    public void launchApplication() {
        driver.manage().timeouts().implicitlyWait(PropertiesReader.getImplicitlyWait(), TimeUnit.SECONDS);
        driver.get(PropertiesReader.getApplicationUrl());
    }

    /**
     * Clicks on Hamburger menu on the application
     *
     * @param locator
     */
    public void clickOnHamburger(String locator) {
        WebElement element = FindElements.findByCss(driver, locator);
        element.click();
    }

    /**
     * Selects the Category link from the Hamburger menu
     *
     * @param locator
     * @param category
     */
    public void selectOnCategoryMenuLink(String locator, String category) {
        WebElement element = FindElements.findElementByXpath(driver, String.format(locator, category));
        CommonMethods.clickElement(driver, element);
        try {
            element.click();
        } catch (Exception e) {
        }
    }


}

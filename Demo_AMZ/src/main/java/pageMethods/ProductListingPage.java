package main.java.pageMethods;

import main.java.dataProvider.PropertiesReader;
import main.java.utils.FindElements;
import main.java.utils.JavaScriptUtils;
import main.java.utils.WaitUtils;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductListingPage extends TestBase {

    /**
     * Select the brand filter from the side filter bar
     */
    public void selectBrandFilter(String brand) {
        JavaScriptUtils.scrollTheViewForElement(driver, PropertiesReader.getProperties("brandFilterSection"), "xpath");
        WaitUtils.waitForUiLoading();
        List<WebElement> brands = FindElements.findElementsByXpath(driver, PropertiesReader.getProperties("brandOptions"));
        for (int i = 1; i < brands.size(); i++) {
            if (brands.get(i).getText().equals(brand)) {
                List<WebElement> checkbox = FindElements.findElementsByXpath(driver, PropertiesReader.getProperties("brandFilter"));
                checkbox.get(i).click();
            }
        }

    }

    /**
     * Selects the product sorting filter for High to Low
     */
    public void selectSortingFilter() {
        WebElement sortFilter = WaitUtils.explicitWaitForElement(driver, PropertiesReader.getProperties("sortFilter"));
        sortFilter.click();
        WebElement options = FindElements.findByCss(driver, PropertiesReader.getProperties("sortingOption"));
        options.click();
    }

    /**
     * Used to find and click on the second largest priced product from the sorted list
     */
    public void findAndClickOnSecondLargestPricedProduct() {
        WaitUtils.waitForUiLoading();
        List<WebElement> prices = FindElements.findElementsByXpath(driver, PropertiesReader.getProperties("productPrice"));
        float price = Float.parseFloat(prices.get(0).getText().replace(",", ""));
        float firstMaxValue = price;
        for (int i = 1; i < prices.size(); i++) {
            price = Float.parseFloat(prices.get(i).getText().replace(",", ""));
            if (price < firstMaxValue) {
                prices.get(i).click();
                break;
            }
        }
    }
}

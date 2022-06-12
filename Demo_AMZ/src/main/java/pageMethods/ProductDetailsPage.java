package main.java.pageMethods;

import io.qameta.allure.Allure;
import main.java.dataProvider.PropertiesReader;
import main.java.utils.CommonMethods;
import main.java.utils.FindElements;
import main.java.utils.JavaScriptUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailsPage extends TestBase {

    /**
     * Validate the product details page redirection in a new window
     */
    public void validateThePageNavigationToPDP() {
        CommonMethods.switchToSecondWindowTab(driver);
    }

    /**
     * Navigate to the product Details page Header for About the item
     *
     * @return
     */
    public boolean NavigateToProductInformation() {
        WebElement options = JavaScriptUtils.scrollTheViewForElement(driver, PropertiesReader.getProperties("productDetailHeader"), "css");
        boolean header = options.getText().contains("About this item");
        Allure.addAttachment("Product Details Header:: ", options.getText());
        return header;
    }

    /**
     * Get all the Details about the Product from PDP
     */
    public void getTheProductInformation() {
        String description = "";
        List<WebElement> content = FindElements.findElementsByXpath(driver, PropertiesReader.getProperties("productDetails"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < content.size(); i++) {
            jse.executeScript("scroll(0, 1000);");
            description = description + content.get(i).getText() + '\n' + '\n';
        }
        Allure.addAttachment("About This Item", description);
        System.out.println(description);
    }
}

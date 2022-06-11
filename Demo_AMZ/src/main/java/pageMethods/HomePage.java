package main.java.pageMethods;

import main.java.dataProvider.PropertiesReader;
import main.java.utils.CommonMethods;
import main.java.utils.FindElements;
import main.java.utils.JavaScriptUtils;
import main.java.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class    HomePage {

    private static WebDriver driver;

    public static void launchApplication(String url){
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
    }

    public static void clickOnHamburger(String locator){
        WebElement element = FindElements.findByCss(driver,locator);
        element.click();
    }
    public static void selectOnCategoryMenuLink(String locator, String category) {
        WebElement element = FindElements.findElementByXpath(driver, String.format(locator, category));
        CommonMethods.clickElement(driver, element);
        try {
            element.click();
        } catch (Exception e) {
        }
    }


    public static void selectBrandFilter(){
        JavaScriptUtils.scrollToPixelViewforElement(driver,PropertiesReader.getElements("brandFilterSection"),"xpath");
        WaitUtils.waitForUiLoading();
        List<WebElement> brands=FindElements.findElementsByXpath(driver,PropertiesReader.getElements("brandOptions"));
        for(int i=1;i<brands.size();i++) {
            if (brands.get(i).getText().equals("Samsung"))//matching for samsung only
            {
               List<WebElement> checkbox = FindElements.findElementsByXpath(driver,PropertiesReader.getElements("brandFilter"));
                checkbox.get(i).click();//clicking on samsung
            }
        }

    }

    public static void selectSortingFilter(){
        WebElement sortFilter= WaitUtils.explicitWaitForElement(driver,PropertiesReader.getElements("sortFilter"));
       sortFilter.click();
       WebElement options = FindElements.findByCss(driver, PropertiesReader.getElements("sortingOption"));
        options.click();

    }

    public static void findSecondLargestPricedProduct() {
        WaitUtils.waitForUiLoading();
        List<WebElement> prices=FindElements.findElementsByXpath(driver,PropertiesReader.getElements("productPrice"));
       float price= Float.parseFloat(prices.get(0).getText().replace(",",""));
       float firstMaxValue=price;
       for(int i=1;i<prices.size();i++){
            price= Float.parseFloat(prices.get(i).getText().replace(",",""));
           if(price<firstMaxValue) {
              prices.get(i).click();
              break;
           }
       }
    }

    public static void validateThePageNavigationToPDP(){
        CommonMethods.switchToSecondWindowTab(driver);
    }

    public static void NavigateProductInformation(){
        WebElement options=JavaScriptUtils.scrollToPixelViewforElement(driver,PropertiesReader.getElements("productDetailHeader"),"css");
        boolean ex= options.getText().contains("About this item");
        Assert.assertTrue(ex,"Content is not matched");
    }

public static void getTheProductInformation(){
        List<WebElement> content=FindElements.findElementsByXpath(driver,PropertiesReader.getElements("productDetails"));
         JavascriptExecutor jse = (JavascriptExecutor)driver;
          for(int i=0;i< content.size();i++){
            jse.executeScript("scroll(0, 1000);");
            String description=content.get(i).getText();
            System.out.println(description);
        }
}



}

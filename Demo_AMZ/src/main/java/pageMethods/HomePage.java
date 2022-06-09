package main.java.pageMethods;

import main.java.dataProvider.PropertiesReader;
import main.java.utils.CommonMethods;
import main.java.utils.FindElements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class    HomePage {

    private static WebDriver driver;
   private static final JavascriptExecutor js = (JavascriptExecutor) driver;

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
        WebElement element = FindElements.findElementByXpath(driver, String.format(locator,category));
        CommonMethods.clickElement(driver,element);
       // Assert.assertEquals(CommonMethods.getElementText(element),category);
    }

    public static void selectTheBrandFilter(){
       // driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
        WebElement element = FindElements.findElementByXpath(driver, "//div[@class='a-column a-span12 apb-browse-left-nav apb-browse-col-pad-right a-span-last']//div[@class='a-row']");
        CommonMethods.clickElement(driver,element);
        List<WebElement> brands=FindElements.findElementsByXpath(driver,"//div[@id='s-refinements']/div[19]");
        js.executeScript("arguments[0].scrollIntoView();", brands);
       // List<WebElement> brands = driver.findElements(By.xpath());
        System.out.println(brands.size());
        for(int i=0;i<brands.size();i++){
            System.out.println(brands.get(i).getText());//fetching all the brands
            if(brands.get(i).getText().equals("Samsung"))//matching for samsung only
            {
                brands.get(i).click();//clicking pon samsung
            }
           // brands = driver.findElements(By.xpath("//div[@id='list-tagcloud']/div[2]/a"));//for cache
        }
    }

    public static void tryOut(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //WebElement element = FindElements.findElementByXpath(driver,"//div[@id='sobe_d_b_6-carousel']");
        WebElement element = null;
       try {
             element = FindElements.findElementByXpath(driver, "//div[@id='s-refinements']/div[19]/div[1]/span[1]");
        }catch (Exception e){

            jse.executeScript("scroll(0, 250);");
        }
        while(element==null) {
            try {
                element = FindElements.findElementByXpath(driver, "//div[@id='s-refinements']/div[19]/div[1]/span[1]");
            }catch (Exception e){
            }
            jse.executeScript("scroll(0, 250);");
        }
        List<WebElement> brands=FindElements.findElementsByXpath(driver,"//div[@id='s-refinements']/div[19]/ul[1]//span[@class='a-size-base a-color-base']");
        System.out.println(brands.size());
        for(int i=0;i<brands.size();i++) {
            WebElement brand=FindElements.findElementByXpath(driver,String.format(PropertiesReader.getElements("brandFilter"),i));
            System.out.println(brands.get(i).getText());//fetching all the brands
            if (brands.get(i).getText().equals("Samsung"))//matching for samsung only
            {
                WebElement checkbox = FindElements.findElementByXpath(driver, "//div[@id='s-refinements']/div[19]/ul[1]/li[2]/span[1]//i");
                checkbox.click();//clicking pon samsung
            }
        }

    }

    public static void selectBrandFilter(){
        WebElement sortFilter=FindElements.findElementByXpath(driver,"//div[@class='sg-col-inner']//span[@id='a-autoid-0-announce']");
        sortFilter.click();
        WebElement options=FindElements.findElementByXpath(driver, "//ul[@class='a-nostyle a-list-link']//li");
        Select filterOption= new Select(options);
        filterOption.selectByValue("Price: High to Low");
       /* driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        Select sortBy=new Select(FindElements.findElementByXpath(driver,"//select[@name='s']"));
        sortBy.selectByValue("price-asc-rank");
        driver.quit();*/
    }



}

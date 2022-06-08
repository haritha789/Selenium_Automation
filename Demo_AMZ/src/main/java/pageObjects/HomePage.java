package main.java.pageObjects;

import main.java.dataProvider.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.CSS, using = "#nav-hamburger-menu")
    private WebElement btn_hamburger;

    @FindBy(how = How.XPATH, using = "//a[@data-menu-id='9']")
    private WebElement link_selectCategory;

}

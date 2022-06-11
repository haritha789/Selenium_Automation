package test.java.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import main.java.dataProvider.PropertiesReader;
import main.java.pageMethods.HomePage;
import main.java.utils.CommonMethods;

public class Amazon {

    public Amazon(){
        PropertiesReader.getProperties();
    }

    @Given("^User Open the Url and navigated to Home page$")
    public void userOpenTheUrlAndNavigateToHomePage(){
        HomePage.launchApplication(PropertiesReader.getApplicationUrl());
    }

    @When("Navigate to Hamburger menu and Choose category as {string} and subcategory as {string}")
    public void navigateToHamburgerMenuAndChooseCategoryAsAndSubcategoryAs(String category,String subcategory) {
        HomePage.clickOnHamburger(PropertiesReader.getElements("hamburger"));
        HomePage.selectOnCategoryMenuLink(PropertiesReader.getElements("menuCategoryLink"),category);
        HomePage.selectOnCategoryMenuLink(PropertiesReader.getElements("menuSubcategoryLink"),subcategory);
    }

    @And("Click on {string} under {string} subsection")
    public void clickOnUnderSubsection(String finalChoice, String subsection) {
        HomePage.selectOnCategoryMenuLink(PropertiesReader.getElements("menuSubSectionLink"),subsection);
        HomePage.selectOnCategoryMenuLink(PropertiesReader.getElements("menuFinalSectionLink"),finalChoice);
    }

    @And("Scroll down and select the brand as {string}")
    public void scrollDownAndSelectTheBrandAs(String brandFilter) {
        HomePage.selectBrandFilter();

    }

    @And("Apply the sorting filter for price as {string}")
    public void applyTheSortingFilterForPriceAs(String sortFilter) {
        HomePage.selectSortingFilter();
        HomePage.findSecondLargestPricedProduct();
         HomePage.validateThePageNavigationToPDP();
        HomePage.NavigateProductInformation();
        HomePage.getTheProductInformation();
    }
}

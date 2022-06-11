package test.java.definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import main.java.dataProvider.PropertiesReader;
import main.java.pageMethods.HomePage;
import main.java.pageMethods.ProductDetailsPage;
import main.java.pageMethods.ProductListingPage;
import main.java.pageMethods.TestBase;
import org.testng.Assert;

public class Amazon {

    HomePage homePage;
    ProductListingPage plp;
    ProductDetailsPage pdp;

    public Amazon() {
        PropertiesReader.getProperties();
        homePage = new HomePage();
        plp = new ProductListingPage();
        pdp = new ProductDetailsPage();
    }

    @Given("Launch the browser and the web url")
    public void launchTheBrowserAndTheWebUrl() {
        TestBase.startBrowser();
    }

    @Given("^User Open the Url and navigated to Home page$")
    public void userOpenTheUrlAndNavigateToHomePage() {
        homePage.launchApplication();
    }

    @When("Navigate to Hamburger menu and Choose category as {string} and subcategory as {string}")
    public void navigateToHamburgerMenuAndChooseCategoryAsAndSubcategoryAs(String category, String subcategory) {
        homePage.clickOnHamburger(PropertiesReader.getProperties("hamburger"));
        homePage.selectOnCategoryMenuLink(PropertiesReader.getProperties("menuCategoryLink"), category);
        homePage.selectOnCategoryMenuLink(PropertiesReader.getProperties("menuSubcategoryLink"), subcategory);
    }

    @And("Click on {string} under {string} subsection")
    public void clickOnUnderSubsection(String finalChoice, String subsection) {
        homePage.selectOnCategoryMenuLink(PropertiesReader.getProperties("menuSubSectionLink"), subsection);
        homePage.selectOnCategoryMenuLink(PropertiesReader.getProperties("menuFinalSectionLink"), finalChoice);
    }

    @And("Scroll down and select the brand as {string}")
    public void scrollDownAndSelectTheBrandAs(String brandFilter) {
        plp.selectBrandFilter(brandFilter);
    }

    @And("Apply the sorting filter for price as High to Low")
    public void applyTheSortingFilterForPriceAsHighToLow() {
        plp.selectSortingFilter();
    }

    @And("Click on the second highest priced item from the list")
    public void clickOnTheSecondHighestPricedItemFromTheList() {
        plp.findAndClickOnSecondLargestPricedProduct();
    }

    @And("Product url is switched to open the PDP page")
    public void productUrlIsSwitchedToOpenThePDPPage() {
        pdp.validateThePageNavigationToPDP();
    }

    @Then("Validate and Assert “About this item” section and log the section text")
    public void validateAndAssertAboutThisItemSectionAndLogTheSectionText() {
        boolean header = pdp.NavigateToProductInformation();
        Assert.assertTrue(header, "Content is not matched");
        pdp.getTheProductInformation();
    }
}

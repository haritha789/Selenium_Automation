package test.java.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import main.java.dataProvider.PropertiesReader;
import main.java.pageMethods.HomePage;
import org.testng.Assert;

public class Amazon {

    public Amazon(){
        PropertiesReader.getProperties();
    }

    @Given("^User Open the Url and navigated to Home page$")
    public void user_open_the_url_and_navigate_to_home_page(){
        HomePage.launchApplication(PropertiesReader.getApplicationUrl());
    }

    @When("Navigate to Hamburger menu & Choose {string} under {string} section")
    public void navigateToHamburgerMenuChooseUnderSection(String subsection, String section) {
        HomePage.clickOnHamburger(PropertiesReader.getElements("hamburger"));
        HomePage.selectCategory(PropertiesReader.getElements("tvAndAppliancesSection"));
    }
}

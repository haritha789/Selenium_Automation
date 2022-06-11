@amazon
Feature: Amazon
  Description: Validation of the key flows on the Amazon

  Background:
    Given  Launch the browser and the web url

  @TC1
  Scenario: Verify the Homepage component API with a PageId, appId and Fields
    Given User Open the Url and navigated to Home page
    When Navigate to Hamburger menu and Choose category as "shop by department" and subcategory as "TV, Appliances, Electronics"
    And  Click on "Televisions" under "tv, audio & cameras" subsection
    And  Scroll down and select the brand as "Samsung"
    And  Apply the sorting filter for price as High to Low
    And  Click on the second highest priced item from the list
    And  Product url is switched to open the PDP page
    Then Validate and Assert “About this item” section and log the section text
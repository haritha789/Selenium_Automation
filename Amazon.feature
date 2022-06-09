Feature: Amazon
  Description: Validation of the key flows on the Amazon

  Scenario: Verify the Homepage component API with a PageId, appId and Fields
    Given User Open the Url and navigated to Home page
    When Navigate to Hamburger menu and Choose category as "shop by department" and subcategory as "TV, Appliances, Electronics"
    And  Click on "Televisions" under "tv, audio & cameras" subsection
    And  Scroll down and select the brand as "Samsung"
    And  Apply the sorting filter for price as "High to Low"

# Amazon Web Automation

A test automation framework for Amazon.in

Written in Java, using Selenium WebDriver, TestNG, Maven, and the Page Object Model, BDD+ Cucumber

An automation portfolio project by [@HarithaGoluguri](https://www.linkedin.com/in/haritha-goluguri-a59805120/)

## Features

- Use of the PageFactory class and the FindBy annotation to create Page Objects

- CSS and XPath selectors to find HTML elements on a page

- Methods for automating links, buttons, dropdowns and checkboxes

- Handling of different waits

- Used the feature files to execute the test cases

- Allure reporting capabilities

- Lombok for the POJO's
## Installation

Dependecies needed for the project

```bash
Language Used : Core Java
Plugin needs to be install : Cucumber for Java,Gherkin,Lombok, 
JDK : 1.8
Set your environment variables
Build Used : Maven
IDE : IntelliJ
Testing Framework: TestNG
Reports: Allure Dependencies
Browser: chromedriver or firefox driver Dependencies
```
    
## Project Scope

- Given User Open the Url and navigated to Home page

- Navigate to Hamburger menu and Choose category as "shop by department" and subcategory as "TV, Appliances, Electronics"
   
- Click on "Televisions" under "tv, audio & cameras" subsection

- Scroll down and select the brand as "Samsung"

- Apply the sorting filter for price as High to Low

- Click on the second highest priced item from the list

- Product url is switched to open the PDP page

- Validate and Assert “About this item” section and log the section text
## Utilities

- A DriverFactory utility class for encapsulating driver object creation in a static factory method

- A CommonMethods utility class for the commonly used functions across the automation scripts

- A JavaScript utility class for handle the used JavaScript execution during automation

- A WaitUtils utility class to handle the explicit wait and UI wait load time during automation
## Benefits

- Define Pages and describe them as a hierarchy structure.

- Define Pages.java for navigation

- Define test data in configuration files

- Define functions to finish the user operation, page navigation and the business logic.
## Execution

Test scripts can be executed by providing below maven command

```bash
 mvn clean test -Dbrowser=safari -Dcucumber.options="--tags @TC1"
```
## Reports
<img width="1680" alt="Screen Shot 2022-06-12 at 3 58 13 PM" src="https://user-images.githubusercontent.com/65031841/173232493-ab608fb5-3c1d-49f1-892e-da11ad78f25a.png">
<img width="1680" alt="Screen Shot 2022-06-12 at 4 13 10 PM" src="https://user-images.githubusercontent.com/65031841/173232580-8afdc006-2ed5-4ffb-9c08-7a131c10fe37.png">
<img width="1680" alt="Screen Shot 2022-06-12 at 4 12 52 PM" src="https://user-images.githubusercontent.com/65031841/173232585-f0dad81f-e7eb-460a-8b93-53b3bf84a7ef.png">




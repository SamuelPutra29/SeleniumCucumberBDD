@smoke
Feature: Customers

  Scenario: Add a new customer
    Given User launch chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    And User click on Customer info
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added"
    And close browser

    Scenario: Add second customer
      Given User launch chrome browser


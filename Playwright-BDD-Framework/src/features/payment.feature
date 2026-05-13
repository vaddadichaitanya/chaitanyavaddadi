Feature: E-Commerce Checkout Process

  Scenario: Successful checkout of an item
    Given I am on the saucedemo login page
    When I login with standard_user and secret_sauce
    And I add a product to the cart
    And I go to the cart and checkout
    And I fill in my checkout information
    And I complete the purchase
    Then I should see the checkout complete message

Feature: Payment Processing
  Scenario: Successful Credit Card Payment
    Given I am on the checkout page
    When I enter valid card details
    And I submit the payment
    Then the payment should be successful

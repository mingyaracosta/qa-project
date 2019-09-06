Feature: Transaction Register
  As an end user
  I want to register a transaction

  Scenario: Successful transaction register by UI
    Given The following data transactionAmount: 50.0
    When I browse to the main page
    And I fill the transaction amount input
    And I click in the submit button
    Then I'm shown 50.0 as the last transaction registered
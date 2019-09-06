Feature: Transaction listing
  As a web clientComo un cliente de API WEB (no humano)
  I want to list all transactions

  Scenario: Successful transactions listing
    Given The following url for the consuming the web service 'http://localhost:7878/api/transactions'
    When I prepare the JSON for the GET request
    And I perform the request
    Then I get a response with a 200 http status

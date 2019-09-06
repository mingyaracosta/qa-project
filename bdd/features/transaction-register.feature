Feature: Transaction register
  As a web clientComo un cliente de API WEB (no humano)
  I want to register a transaction

  Scenario: Successful transaction register by API
    Given The following data transactionAmount 45
    Given The following url for the consuming the web service 'http://localhost:7878/api/transactions/process-transaction'
    When I prepare the JSON for the POST request
    And I perform the request
    Then I get a response with a 201 http status

Feature: Payment Microservice API Tests

Background:
  * url 'https://api.payments.internal'

Scenario: Process a successful charge
  Given path '/v1/charges'
  And request { amount: 2000, currency: 'usd', source: 'tok_visa' }
  When method post
  Then status 200
  And match response.status == 'succeeded'
  And match response.id == '#notnull'

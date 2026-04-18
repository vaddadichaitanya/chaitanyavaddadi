Feature: PCI-DSS Compliance Validation
  Scenario: Credit card numbers are masked in audit logs
    Given a transaction is processed with card "4111222233334444"
    When I query the audit logs
    Then the card number should be masked as "4111********4444"

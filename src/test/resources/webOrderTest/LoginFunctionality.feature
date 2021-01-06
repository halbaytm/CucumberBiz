Feature: Testing Log in functionality

  Scenario: Testing

    Given User navigates to WebOrders application
    When User provides username "Tester" and password "test"
    Then User validates that application logged in

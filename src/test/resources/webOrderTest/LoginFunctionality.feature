Feature: Testing Log in functionality

  Scenario: Testing

    Given User navigates to WebOrders application
    When User provides username "Tester" and password "test"
    Then User validates that application "is" logged in


  Scenario: Testing log in functionality with invalid credentials

    Given User navigates to WebOrders application
    When User provides username "Tester" and password "Tester"
    Then User validates that application "is not" logged in





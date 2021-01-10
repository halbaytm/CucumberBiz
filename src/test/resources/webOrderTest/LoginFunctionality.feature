@smoketest @regressiontest @TEC-1001
Feature: Testing Log in functionality

  @TEC-2001
  Scenario: Testing log in functionality with valid credentials
    Given User navigates to WebOrders application
    When User provides username "Tester" and password "test"
    Then User validates that application "is" logged in

  @TEC-2002
  Scenario: Testing log in functionality with invalid credentials
    Given User navigates to WebOrders application
    When User provides username "Tester" and password "Tester"
    Then User validates that application "is not" logged in





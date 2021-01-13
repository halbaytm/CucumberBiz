@smoketest @regressiontest @TEC-1001
Feature: Testing Log in functionality

  @TEC-2001 @TEC-2002
  Scenario Outline: Testing log in functionality with valid/invalid credentials
    Given User navigates to WebOrders application
    When User provides username "<username>" and password "<password>"
    Then User validates that application "<condition>" logged in

    Examples:

      | username | password | condition |
      | Tester   | test     | is        |
      | tester   | tester   | is not    |






Feature: Order Creation Functionality

  @TC-101
  Scenario: Creating order with valid data
    Given User navigates to WebOrders application
    When User provides username "Tester" and password "test"
    Then User validates that application "is" logged in
    When User click on Order part
    And User adds new order

      | Quantity | Customer name | Street      | City        | Zip   | State | Card Nr | Expire Date |
      | 2        | John Doe      | 123 Doe St. | Des Plaines | 60006 | IL    | 1234567 | 12/21       |

    Then User click on Process button and validate "New order has been successfully added." message
    When User click View All Orders part
    Then User created order is added to list with data

      | Quantity | Customer name | Street      | City        | Zip   | State | Card Nr | Expire Date |
      | 2        | John Doe      | 123 Doe St. | Des Plaines | 60006 | IL    | 1234567 | 12/21       |



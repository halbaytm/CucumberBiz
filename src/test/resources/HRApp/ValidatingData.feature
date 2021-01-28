@TEC-1020 @ui @db @regressiontest
Feature: Validating UI employee data with DB

  Scenario: Validating first four employees from UI data with DB
    Given User navigates to MyApp homepage
    When User get all data from UI
    Then User validates ui data with db data

Feature: Login feature

  Scenario: Login Success
    Given I open a browser
    And I open the Login Page
    When I enter the email address"raul.garcia@testpro.io"
    And I enter the password "te$t$tudent"
    And I submit
    Then I am logged in
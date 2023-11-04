Feature: Login to Swag Labs Web

  @positive
  Scenario: login using valid credential
    Given user on login page
    When user input valid username
    And user input valid password
    And user click login button
    Then user should redirect to products page

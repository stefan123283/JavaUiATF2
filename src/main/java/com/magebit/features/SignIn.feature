Feature: Sign In Related Test Cases

  Background:
    Given "customer/account/" end-part is accessed

  @SignInSmoke1
  Scenario: The account page is accessed after successful sign in
    When the following form from "SignInPage" is populated as follow:
      | emailInput    | jillian.schaefer@yahoo.com |
      | passwordInput | ZbV8qqg1                   |
    And the "signInBtn" from "SignInPage" is clicked
    Then the current url contains "index" keyword

  @SignInSmoke2
  Scenario Outline: An error message is displayed when using invalid <attribute> for sign in flow
    When the following form from "SignInPage" is populated as follow:
      | emailInput    | <email>    |
      | passwordInput | <password> |
    And the "signInBtn" from "SignInPage" is clicked
    Then the following list of messages is displayed:
      | The account sign-in was incorrect or your account is disabled temporarily. |
    Examples:
      | email                      | password  | attribute |
      | user1@gmail.com            | ZbV8qqg1  | email     |
      | jillian.schaefer@yahoo.com | Pa$sword1 | password  |
Feature: Register Related Test Cases

  Background:
    Given "customer/account/create/" end-part is accessed

  Scenario: The Account Page URL is opened when the registration is successful
    When the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | RandomFirstName |
      | lastNameInput        | RandomLastName  |
      | emailInput           | RandomEmail     |
      | passwordInput        | RandomPassword  |
      | confirmPasswordInput | RandomPassword  |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    Then the following list of messages is displayed:
      | Thank you for registering with Main Website Store. |
Feature: Register Related Test Cases

  Background:
    Given "customer/account/create/" end-part is accessed

  Scenario: The Account Page URL is opened when the registration is successful
    When the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | RandomFirstName |
      | lastNameInput        | RandomLastName  |
      | emailInput           | RandomEmail     |
      | passwordInput        | RandomPassword  |
      | confirmPasswordInput | RandomPassword |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    Then the following list of messages is displayed:
      | Thank you for registering with Main Website Store. |

    @Smoke2
  Scenario Outline: An error message is displayed when invalid password is used for register flow
    When the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | <firstName>       |
      | lastNameInput        | <lastName>        |
      | emailInput           | <email>           |
      | passwordInput        | <password>        |
      | confirmPasswordInput | <confirmPassword> |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    Then the following list of messages is displayed:
      | Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored. |
      | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |
    Examples:
      | firstName | lastName | email             | password | confirmPassword |
      | person    | 1        | person1@gmail.com | user123  | user123         |
      | person    | 2        | person2@gmail.com | user1234 | user1234        |

Feature: Register Related Test Cases

  Background:
    Given "customer/account/create/" end-part is accessed

  @Smoke1
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

  @Smoke2
  Scenario: An error message is displayed when the password is shorter than 8 characters
    When the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | randomFirstName |
      | lastNameInput        | randomLastName  |
      | emailInput           | randomEmail     |
      | passwordInput        | user123         |
      | confirmPasswordInput | user123         |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    Then the following list of messages is displayed:
      | Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored. |

  @Smoke3
  Scenario: An error message is displayed when the password does not contain 3 different classes of characters
    When the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | randomFirstName |
      | lastNameInput        | randomLastName  |
      | emailInput           | randomEmail     |
      | passwordInput        | user1234        |
      | confirmPasswordInput | user1234        |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    Then the following list of messages is displayed:
      | Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters. |

  @Smoke4
  Scenario: An error message is displayed when the email address utilized for register flow is already used by another user
    When the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | randomFirstName     |
      | lastNameInput        | randomLastName      |
      | emailInput           | leo.adams@yahoo.com |
      | passwordInput        | randomPassword      |
      | confirmPasswordInput | randomPassword      |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    Then the following list of messages is displayed:
      | There is already an account with this email address. |

  @Smoke5
  Scenario: A warning message is displayed when the password and confirm password used for register flow are not equal
    When the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | randomFirstName |
      | lastNameInput        | randomLastName  |
      | emailInput           | randomEmail     |
      | passwordInput        | Admin12$        |
      | confirmPasswordInput | Admin$21        |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    Then the following list of messages is displayed:
      | Please enter the same value again. |

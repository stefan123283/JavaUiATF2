Feature: Account Related Test Cases

  Background:
    Given "customer/account/" end-part is accessed

  @AccountSmoke1
  Scenario: The user's email and password are successfully edited using valid data
    And the "createAccountBtn" from "SignInPage" is clicked
    And the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | RandomFirstName |
      | lastNameInput        | RandomLastName  |
      | emailInput           | RandomEmail     |
      | passwordInput        | RandomPassword  |
      | confirmPasswordInput | RandomPassword  |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    And the "accountInfLink" from "AccountPage" is clicked
    And the "emailCheck" from "AccountPage" is clicked
    And the "passwordCheck" from "AccountPage" is clicked
    And the following form from "AccountPage" is populated as follow:
      | emailInput              | RandomEmail    |
      | currentPasswordInput    | RandomPassword |
      | newPasswordInput        | Pa$sword123    |
      | confirmNewPasswordInput | Pa$sword123    |
    When the "saveBtn" from "AccountPage" is clicked
    Then the following list of messages is displayed:
      | You saved the account information. |

  @AccountSmoke2
  Scenario: A warning message is displayed if the user is changing his email to one that belongs to another user
    And the "createAccountBtn" from "SignInPage" is clicked
    And the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | RandomFirstName |
      | lastNameInput        | RandomLastName  |
      | emailInput           | RandomEmail     |
      | passwordInput        | RandomPassword  |
      | confirmPasswordInput | RandomPassword  |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    And the "accountInfLink" from "AccountPage" is clicked
    And the "emailCheck" from "AccountPage" is clicked
    And the following form from "AccountPage" is populated as follow:
      | emailInput           | jeremiah.hahn@yahoo.com |
      | currentPasswordInput | RandomPassword          |
    When the "saveBtn" from "AccountPage" is clicked
    Then the following list of messages is displayed:
      | A customer with the same email address already exists in an associated website. |

  @AccountSmoke3
  Scenario: A warning message is displayed if the user is introducing an invalid password when he/she is trying to edit the email or the password
    And the "createAccountBtn" from "SignInPage" is clicked
    And the following form from "CreateAccountPage" is populated as follow:
      | firstNameInput       | RandomFirstName |
      | lastNameInput        | RandomLastName  |
      | emailInput           | RandomEmail     |
      | passwordInput        | RandomPassword  |
      | confirmPasswordInput | RandomPassword  |
    And the "createAccountBtn" from "CreateAccountPage" is clicked
    And the "accountInfLink" from "AccountPage" is clicked
    And the "emailCheck" from "AccountPage" is clicked
    And the following form from "AccountPage" is populated as follow:
      | emailInput           | RandomEmail     |
      | currentPasswordInput | invalidPassword |
    When the "saveBtn" from "AccountPage" is clicked
    Then the following list of messages is displayed:
      | The password doesn't match this account. Verify the password and try again. |

#  @AccountSmoke4
#  Scenario: The user is able to add details about his/her address
#    And the "createAccountBtn" from "SignInPage" is clicked
#    And the following form from "CreateAccountPage" is populated as follow:
#      | firstNameInput       | RandomFirstName |
#      | lastNameInput        | RandomLastName  |
#      | emailInput           | RandomEmail     |
#      | passwordInput        | RandomPassword  |
#      | confirmPasswordInput | RandomPassword  |
#    And the "createAccountBtn" from "CreateAccountPage" is clicked
#    And the "accountAddressLink" from "AccountPage" is clicked
#    And the following form from "AccountPage" is populated as follow:
#      | <inputType> | <value> |
#    And the "stateSelectValue" from "AccountPage" is selected
#    When the "saveAddressBtn" from "AccountPage" is clicked
#    Then the following list of messages is displayed:
#      | You saved the address. |



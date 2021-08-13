Feature: Sanity tests

  Background: Statefarm 100 for Good Launch
    Given I launch the browser
    Then I print the url


@RegressionTest
  Scenario: Login Assertions
    When I assist text "Register" with identifier "register" 
    Then element with identifier "emailId" is asserted
    And element with identifier "emailId" is clicked
    When element with identifier "password" is asserted
    Then element with identifier "password" is clicked
    When element with identifier "logInBtn" is asserted


@RegressionTest
  Scenario: Login - Email ID wrong format
    Then element with identifier "emailId" is asserted
    And element with identifier "emailId" is clicked
    Then text "random@domain@domain.com" is entered in the identifier "emailId"
    When element with identifier "password" is asserted
    Then element with identifier "password" is clicked


 @RegressionTest
  Scenario: Login - Valid registered State Farm email id and correct password
    Then element with identifier "emailId" is asserted
    And element with identifier "emailId" is clicked
    And text "abu.jamal@ymedialabs.com" is entered in the identifier "emailId"
    When element with identifier "password" is asserted
    Then element with identifier "password" is clicked
    And text "Password@1234" is entered in the identifier "password"
    When element with identifier "logInBtn" is asserted
    Then element with identifier "logInBtn" is clicked
      

@RegressionTest
  Scenario: Login - Unregistered email id and valid password
    Then element with identifier "emailId" is asserted
    And element with identifier "emailId" is clicked
    And text "test.user@ymedialabs.com" is entered in the identifier "emailId"
    When element with identifier "password" is asserted
    Then element with identifier "password" is clicked
    And text "Abcd!234" is entered in the identifier "password"
    When element with identifier "logInBtn" is asserted
    Then element with identifier "logInBtn" is clicked
   When wait for the text "Looks like we can't log you in right now. You may not be registered or the password or email you entered are incorrect. Please try again." with identifier "error-notification" to be present
    

@RegressionTest
  Scenario: Login - non State Farm email address
    Then element with identifier "emailId" is asserted
    And element with identifier "emailId" is clicked
    And text "test.user@gmail.com" is entered in the identifier "emailId"
    When element with identifier "password" is asserted
    Then element with identifier "password" is clicked
    And text "password" is entered in the identifier "password"
    Then element with identifier "logInBt" is asserted
    Then element with identifier "logInBtn" is clicked
    
When wait for element with identifier "error-notification" to be present
#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login Action

  @tag1
  Scenario: Successful Login with Valid Credentials
 		Given User is on Home Page
 		When User Navigate to LogIn Page
 		And User enters UserName and Password
 		Then Message displayed Login Successfully

  @tag2
  Scenario: Successful LogOut
 		Given
 		When User LogOut from the Application
 		And
 		Then Message displayed LogOut Successfully

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |

Feature: I test the login functionality and account management

  Background: I log in into my account
    Given I open "https://www2.hm.com/pl_pl/"
    Then I click on linkText "Zaloguj się"
    And I input my login credentials and login
    And I verify that the account page is displayed


    Scenario: I edit my birthday
      Given I click on linkText "Ustawienia konta"
      And I click to edit my account information
      Then I put "02.02.2000" as my birthday
      And I click "Zapisz"
      And I verify that my birthday is set to "02.02.2000"

    Scenario: I logout
      Given I hover my mouse over "Moje konto"
      And I click on linkText "Wyloguj się"
      And I verify that the login page is displayed
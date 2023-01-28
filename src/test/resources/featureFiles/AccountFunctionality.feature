@Account @Test
Feature: I test the login functionality and account management

    Scenario: : I log in into my account
      Given I open "https://kosmaz.pl/pl"
      Then I click on text "Zaloguj się"
      And I input my login credentials and login
      And I verify that I'm logged in

    @Address
    Scenario: I edit my address
      Given I click on text "Moje konto"
      And I click on linkText "Moje adresy"
      Then I click on linkText "Edytuj"
      And I change the address name field to "testAdres"
      And I verify that "Nazwa adresu" is visible

    Scenario: I logout
      Given I click on text "Moje konto"
      And I click on linkText "Wyloguj"
      And I verify that "Zaloguj się" is visible

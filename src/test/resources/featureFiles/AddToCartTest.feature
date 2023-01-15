Feature: AddToCart

  Scenario: Test the functionality of adding items to the cart
    Given I open "https://kosmaz.pl/pl"
    And I click on linkText "Sklep INTERNETOWY"
    Then I click on linkText "Sklejki"
    And I add the first item to the cart
    Then I check if the item has been added successfully


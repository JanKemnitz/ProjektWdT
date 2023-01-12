Feature: AddToFavourites

  Scenario: Test the functionality of adding items to favourites
    Given I open "https://www2.hm.com/pl_pl/"
    And I click on linkText "Ona"
    Then I click on linkText "Sukienki"
    And I click on the first item
    And I add the item to favourites
    Then I check if the item has been added successfully


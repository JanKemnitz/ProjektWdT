@Search @Test
Feature: Test if the search functionality works correctly

  Background: I log in into my account
    Given I open "https://kosmaz.pl/pl"

    Scenario: I search for a particle board
      When I search for "osb"
      Then I should get more than "5" results containing "Płyta OSB"

    Scenario: I search for a generic product and change the amount of listings per site
      When I search for "płyta"
      Then I should get more than "20" results containing "mm"
      And From the "Produktów na stronę:" dropdown I select "80"
      Then I should get more than "70" results containing "mm"
      
    Scenario Outline: I sort the products by price
      When I search for "osb"
      And From the "Sortuj wg.:" dropdown I select <sortingOption>
      Then The products should be sorted from the <expectedResult>

      Examples:
        | sortingOption   | expectedResult   |
        | "Cena rosnąco"  | "cheapest"       |
        | "Cena malejąco" | "most expensive" |

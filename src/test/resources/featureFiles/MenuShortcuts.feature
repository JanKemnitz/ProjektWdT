@Menu @Test
Feature: Test if the main menu of the website functions properly

  Scenario Outline: I click every main menu shortcut and verify that it works correctly
    Given I open "https://kosmaz.pl/pl"
    And I click on linkText "<menuOption>"
    Then I should be transferred to "<url>"
    Examples:
      | menuOption                    | url                                               |
      | Home                          | https://kosmaz.pl/pl/home                         |
      | My o Nas                      | https://kosmaz.pl/pl/my-o-nas-kosmazpl            |
      | Aktualności                   | https://kosmaz.pl/pl/kategoria/8,aktualnosci      |
      | Porady                        | https://kosmaz.pl/pl/kategoria/11,porady          |
      | Jazda Próbna Kuchni           | https://kosmaz.pl/pl/jazda-probna-kuchni          |
      | Praca                         | https://kosmaz.pl/pl/praca                        |
      | Unia Europejska               | https://kosmaz.pl/pl/ue                           |
      | Kontakt                       | https://kosmaz.pl/pl/kontakt                      |
      | Sklep INTERNETOWY             | https://kosmaz.pl/pl/sklep/kategorie              |
      | eRozrys dla PROFESJONALISTÓW  | https://erozrys.kosmaz.pl/pl/profile/login        |
      | Elementy na WYMIAR            | https://kosmaz.pl/pl/sklep/erozrys-detal          |
      | Konfigurator BLUM             | blum-url                                          |
      | Kalkulator PODNOŚNIKÓW        | https://kosmaz.pl/pl#calculator                   |

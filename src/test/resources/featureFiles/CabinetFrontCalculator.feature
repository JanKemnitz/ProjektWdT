@CabinetCalculator @Test
Feature: Calculator tester

  Scenario Outline: Test if the cabinet front calculator works properly
    Given I open "https://kosmaz.pl/pl"
    And I click on linkText "Kalkulator PODNOŚNIKÓW"
    Then I click on text <cabinetType>
    And From the "Typ siłownika:" dropdown I select <frontType>
    And I input the width of the front "500", thickness "12" and height "300"
    Then I click on text "Sprawdź"
    And From the "Rodzaj uchwytu:" dropdown I select <handleType>
    And I verify that all the values match for a given <cabinetType>

    Examples:
     | cabinetType | frontType | handleType |
     | "Aventos HF" | "Płyta mdf" | "Reling stalowy" |
     | "Aventos HK-S" | "Płyta wiórowa" | "Podwójna gałka" |
     | "Aventos HK" | "Szkło/Alu" | "Pojedynczy uchwyt dwupunktowy" |
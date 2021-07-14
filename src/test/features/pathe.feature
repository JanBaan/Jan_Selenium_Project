Feature: Pathe tests

  Background:
    Given user navigates to the home page

  Scenario Outline: user reads the available columns
    Given user is reading column "<columnName>"
    Examples:
      | columnName |
      | Films |
      | Bioscopen |
      | Events |
      | Pathé All Stars |
      | Pathé Unlimited |
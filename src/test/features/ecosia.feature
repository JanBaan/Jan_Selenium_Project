Feature: Ecosia tests

  Background:
    Given user goes to home page

  Scenario: user search for apples in Home page
    Given user selects the search bar
    Then user types "Apples" in the search bar

  Scenario: user is looking at cat pictures
    Given user selects the search bar
    Then user types "Cats" in the search bar
    And select the "Images" tab

  Scenario: user is looking for news about potatoes
    Given user selects the search bar
    Then user types "Potatoes" in the search bar
    And select the "News" tab

  Scenario: user is looking for videos about water
    Given user selects the search bar
    Then user types "Water" in the search bar
    And select the "Videos" tab

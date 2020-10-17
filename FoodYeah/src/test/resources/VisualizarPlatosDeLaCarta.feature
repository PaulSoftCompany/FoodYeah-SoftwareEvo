Feature: As a user of the application, I want to view the dishes of the menu so that I can choose at
  any time and in any place what I am going to consume.

  Scenario: View the dish's description
    Given a user who wants to view the dishes of the menu,
    When he clicks the button view dishes of the menu,
    Then the application should show the description of each dish: its name, image, ingredients, stock and price

  Scenario: Show the products by the category
    Given a user who wants to view the weekly menu,
    When he clicks the button to filter the products by category,
    Then the application should show the products by the category that the user decided to filter
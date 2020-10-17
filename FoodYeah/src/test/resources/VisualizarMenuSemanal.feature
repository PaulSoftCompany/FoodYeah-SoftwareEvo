Feature: As a user of the application, I want to view the weekly menu to be aware of the menu
  items that will be offered on certain days.

  Scenario: Show description
    Given a user who wants to view the weekly menu,
    When he clicks the view weekly menu button,
    Then the application should show the description of each dish: its name, image, ingredients, stock and price

  Scenario: show the dishes categorized by dates
    Given a user who wants to view the weekly menu,
    When he clicks the view weekly menu button,
    Then the application should show the dishes categorized by dates

  Scenario: update the weekly menu data daily
    Given a user who wants to view the weekly menu,
    When he clicks the view weekly menu button,
    Then the platform must update the weekly menu data daily.

  Scenario: show the products by the category
    Given a user who wants to view the weekly menu,
    When he clicks on the button to filter the products by category,
    Then the application should show the products by the category that the user decided to filter.
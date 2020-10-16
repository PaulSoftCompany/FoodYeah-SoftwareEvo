Feature: As a user of the application, I want to be able to pay online
  my orders to avoid the checkout line

  Scenario: Stock decrease
    Given a user who places an order with a "<quantity>" units of a product,
    When the order is delivered,
    Then the stock must decrease "<quantity>"

  Examples:
    |quantity|
    |1       |
    |2       |
    |3       |
    |4       |

  Scenario: add to shopping cart
    Given an application user who wants to be able to pay through the app to avoid the checkout line,
    When they press the cart icon positioned on the food they select,
    Then it will be added to their shopping cart
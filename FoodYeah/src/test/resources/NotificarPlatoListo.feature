Feature: As a user of the application, I want the application to notify me when my plate is ready to be
  picked up in the university's cafeteria

  Scenario: Stock decrease
    Given a user who places an order with a certain quantity of a product,
    When the order is delivered,
    Then the stock must decrease in relation to the quantity that the user has bought

  Scenario: add to shopping cart
    Given an application user who wants to be able to pay through the app to avoid the checkout line,
    When they press the cart icon positioned on the food they select,
    Then it will be added to their shopping cart
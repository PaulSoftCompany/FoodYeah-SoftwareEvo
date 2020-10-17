Feature: As a user of the application, I want the application to ask me if I am sure of my purchase,
  in order to avoid an unwanted purchase.

  Scenario: application should ask the user if he is sure of his choice
    Given a user who wants to make a transaction
    When he presses the buy button,
    Then the application should ask the user if he is sure of his choice
Feature: As a user of the application, I want to be able to view the cards that I have affiliated to the application,
  to be able to select them and complete my data according to the card that I decided to use.

  Scenario: show a list of the user's cards that he has saved in the application
    Given a user who wants to open a card account
    When he is making a virtual purchase in the application,
    Then the application should show a list of the user's cards that he has saved in the application

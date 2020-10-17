Feature: Purchase confirmation
 As a user of the application, I want the app to ask me if I am sure of my purchase, 
 in order to avoid an unwanted purchase.
 Scenario: Ask for purchase confirmation
    Given a user who wants to make a transaction
    When he presses the buy button
    Then the application should the user if he is sure of his choice
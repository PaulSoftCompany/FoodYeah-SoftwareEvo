Feature: as a user I want it to show me if the card details are valid so that I can correct them

  Scenario: data is invalid
    Given a user who wants to perform a transaction
    When they do not enter all the data or the data is invalid,
    Then the process will be canceled and the user will be notified of the error.

  Scenario: enter data from her debit or credit card
    Given a user who wants to carry out a transaction
    When the application asks her to enter her data,
    Then the user must enter data from her debit or credit card

  Scenario: show the user in a drop-down box the cards saved
    Given a user who wants to carry out a transaction
    When the application asks her to enter her data,
    Then the application must show the user in a drop-down box the cards saved by the user

  Scenario: Notify the user that the purchase was made and that he must pick up
    Given a user making a transaction
    When they do not have enough balance,
    Then the process will be canceled and the user will be notified of the error.
Feature: As a user of the application, I want to affiliate my debit or credit card to the application so that I do not
  re-enter the data of this in each transaction.

  Scenario: not enter all the data or the data is not valid
    Given a user who wants to make a transaction
    And does not have his card affiliated to the application
    When he does not enter all the data or the data is not valid,
    Then the user will not be notified of the option to affiliate his card.

  Scenario: affiliate my debit or credit card to the application
    Given a user who does not have her card affiliated with the application
    When the user fills in her data and makes a purchase,
    Then she must notify the user if she wants the application to remember her data. In case the user says yes, the application must save them in the database, otherwise no.

  Scenario: show the user a box that allows the application to save the data
    Given a user who wants to carry out a transaction
    When the application asks her to enter her data,
    Then the application must show the user a box that allows the application to save the data she has entered
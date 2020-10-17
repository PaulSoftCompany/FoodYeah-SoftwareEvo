Feature: As a user of the application, I want the application to notify me when my plate is ready to be
  picked up in the university's cafeteria

  Scenario: Notify the user that the purchase was made and that he must pick up
    Given a user making a transaction
    When he successfully bought his plate,
    Then the application must notify the user that the purchase was made and that he must pick up his plate in the dining room.

  Scenario: Notify the user of the approximate time to wait for her plate
    Given a user performing a transaction
    When she successfully purchased her plate,
    Then the application should notify the user of the approximate time to wait for her plate. This value has to be calculated by an average of values that the application is capturing that are saved in the database
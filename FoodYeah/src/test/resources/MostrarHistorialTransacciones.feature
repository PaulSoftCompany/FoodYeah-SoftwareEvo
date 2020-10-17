Feature: As a user of the application, I want to view my sales in a list to review in
  detail the data of each transaction I have made.

  Scenario: Notify the user that the purchase was made and that he must pick up
    Given a user who wants to see a certain reservation in greater detail
    When he checks the box on the side of the reservation and clicks the "see detail" button,
    Then the application must show the id, the dish, the amount in soles and the date plus time.

  Scenario: must remove the check from the previous box
    Given a user who wants to view the reservation history
    When he checks more than one box,
    Then the application must remove the check from the previous box.

  Scenario: update the reservation data every minute
    Given a user who wants to view the reservation history
    When he clicks the "Show transaction history" button,
    Then the platform must update the reservation data every minute.
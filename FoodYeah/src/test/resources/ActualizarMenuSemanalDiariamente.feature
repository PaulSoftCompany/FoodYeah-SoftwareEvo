Feature: As a user of the application, I want the information on the weekly menu to be updated daily,
  to always be aware of future products that will be available in a week.

  Scenario: Stock decrease
    Given a user who wants to view the dishes of the menu
    When he clicks the button view dishes of the menu,
    Then the platform must update the weekly menu data daily
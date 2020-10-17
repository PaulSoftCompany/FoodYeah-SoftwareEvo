Feature: as a user I want to put filters to find a specific dish

  Scenario: show all the food filter options
    Given a user who wants to search for a specific dish,
    When he gives the drop-down box to filter dishes,
    Then the platform should show all the food filter options and order them in the order that the user selects

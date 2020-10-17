Feature: Load basic HTML view
 As a user of the application, I want the application to load me the data in HTML 
 in case the system fails to display the data in CSS, so that I can interact with 
 the page without taking priority over the views.
 Scenario: Network errors
    Given an error occurs in loading the application
    When the user experiences network problems
    Then the system will try to show the name of the dishes without an image
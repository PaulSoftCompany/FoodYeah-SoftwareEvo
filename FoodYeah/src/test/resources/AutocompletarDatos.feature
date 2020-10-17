Feature: Card autocompletation 
 As a user of the application, I want the application to automatically fill my card details, 
 to save my shopping time.
 Scenario: Registered card data
    Given a user who has his card affiliated with the application
    When he makes a transaction
    Then most of his card details will be filled in automatically
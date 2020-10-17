Feature: Receive receipt 
 As a user of the application, I want to receive the receipt of my virtual purchase by mail
  and through the application to show the confirmation of my order.
 Scenario: Successful purchase
    Given a user making a transaction
    When he successfully bought his plate
    Then the application must send the recepit to his educational email, wich is afiliated with the university
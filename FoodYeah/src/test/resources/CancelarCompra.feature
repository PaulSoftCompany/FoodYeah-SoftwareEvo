Feature: Cancel purchase
 As a user of the application, I want to be prevented from purchasing a product when this
 product is out of stock, to avoid making a purchase of a currently absent product
 Scenario: Ask for purchase confirmation
    Given a user who wants to make a transaction
    When there is no stock of the dish he has selected
    Then the process will be canceled
        And the user will be notified of the error
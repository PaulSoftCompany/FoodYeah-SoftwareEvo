Feature: Give average time
 As a user of the application I want the average time of the orders, 
 so that the system does not give me the wrong time
 Scenario: Time of previous orders
    Given an application user
    When placing an order
    Then the application must validate if there are previous orders before calculating the average order time
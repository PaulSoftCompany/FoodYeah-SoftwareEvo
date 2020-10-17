Feature: Log in
 As a user of the application, I want to log in to access all the functions that the application offers.
 Scenario: Validate credentials
    Given a user who wants to enter the application
    When he enters his data to log in
    Then the application must only accept the username and password of the UPC account of the user

  Scenario: Wrong credentials
    Given a user who wants to enter the application
    When the data he entered is invalid
    Then the application must remove the characters from the text box of the password
        And notify the user that the data he entered is not valid
 
 Scenario: Keep logged in
    Given a user who wants to enter the application
    When he is in the login screen
    Then the application must show an option that allows the application to keep the session always logged in
 
 Scenario: String limit
    Given a user who wants to enter the application
    When he enters his data to log in
    Then the text box can only admit up to 25 characters maximum as much as in the username and password

 Scenario: Close session
    Given a user who logs in
        And wants to log out
    When he clicks the log out button
    Then the application should close his session
        And take the user to login page
Feature: Login functionality
@incorrectusername @tag1 @tag2 @correctPassword  @smoke
Scenario: Checking for incorrect username and password
Given Load the url
When enter the username
And enter the password
Then click the login button
Then I should see the login page
 


@correctPassword @incorrectusername @smoke @regression
Scenario: Checking for incorrect username and correct password
Given Load the url
When enter the username
And enter the password
Then click the login button
Then I should see the login page

@tag3  @regression
Scenario: Checking for correct username and incorrect password
Given Load the url
When enter the username
And enter the password
Then click the login button
Then I should see the login page
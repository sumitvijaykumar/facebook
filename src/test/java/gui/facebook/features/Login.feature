Feature: As a newly signed up user on Facebook, user goes on exploring facebook app and gets started with using facebook.

Background:
	Given user is already logged in

@post
Scenario: User should be able to login with ID, email and mobile number of a single user.
	Given user sees login page
	When user logs in with "<id>"
	Then user should be logged in for same user
	
#	Examples:
#	|id|

@post	
Scenario: User should see login page as per the language selected
	Given user sees login page
	When user selects "<language>"
	Then user should see login page in "<language>"

#	Examples:
#	|language|
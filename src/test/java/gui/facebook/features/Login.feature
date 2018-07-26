Feature: As a newly signed up user on Facebook, user goes on exploring facebook app and gets started with using facebook.

Background:
	Given user is already logged in

Scenario Outline: User should post and see different kinds of status on it's wall which includes tagging a friend, adding an activity and checking in on a location.

	When user writes status "<text>"
	And user checks in location "<location>"
	And user tags a "<friend>" 
	And user chooses "<feeling>" as "<mood>"
	And user posts status
	Then user should see status on home page with "<text>"
	And status should have "<location>"
	And "<friend>" is tagged in the status
	And status has "<feeling>" with "<mood>"
	
	Examples:
	|text|location|friend|feeling|mood|
	|Wonderful place to explore|Bali|Sumit Vijaykumar|feeling|happy|
Feature: As a newly signed up user on Facebook, user goes on exploring facebook app and gets started with using facebook.

Background:
	Given user is already logged in

Scenario Outline: 
Story: User goes to a vacation to Bali and wants to update status along with a friend with an activity.
	#Given user is connected to "<friend>"
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
	|Wonderful place to explore|Bali|Barack|feeling|happy|

@post	
Scenario:
As user scrolls down the homepage, older feeds should auto load
	When user scrolls down
	Then user should see older posts automatically loading

@post	
Scenario:
 User should be able to edit privacy of post
 	Given logged in user makes post
 	When user sets privacy of post to "Only me"
 	Then friends should not be able to see post
 	When user sets privacy to "Friends"
 	Then only friends should see posts
 	And non-friend user should not see post
 	When user sets privacy of post to "Public"
 	Then non-friend user should see the post
 	
	

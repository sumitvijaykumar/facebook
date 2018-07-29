Feature: As a newly signed up user on Facebook, user goes on exploring facebook app and gets started with using facebook.

Background:
	Given user is already logged in

@post
Scenario:
As a logged in user, user should be able to search a friend on facebook and send him a friend request.
Once the friend approves the friend request, user should see a notification for newly connected friend.

	When Jack searches for a friend having ID "ladee.bhaga.3"
	And Jack sends friend request
	And friend accepts request from "Jack"
	Then "Jack" should be visible in friend list
	Then both friend should be visible in friend list of each other

Scenario Outline:
As a logged in user, two connected friend should be able to send facebook messages to each other.

	When user sends "<message>" to a friend
	Then friend should see notification upon message icon
	When friend replies back to user
	Then user should see friend's "<reply>" 
	And user should see previously sent "<message>" also

	Examples:
	|message|reply|

Scenario Outline: 
Story: User goes to a vacation to Bali and wants to update status along with a friend with an activity.
	Given user is connected to "<friend>"
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
	

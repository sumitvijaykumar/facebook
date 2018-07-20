Feature: This feature files contains basic test scenario for facebook web app

Scenario Outline: To test status update on web app using text, location, tagged friend and mood
	Given user is already logged in
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
	|Wonderful place to explore|Bali|Sumit|feeling|excited|
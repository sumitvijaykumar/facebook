Feature: As a newly signed up user on Facebook, user goes on exploring facebook app and gets started with using facebook.

Background:
	Given "Jack" is logged in
	And "Barack" is logged in

@message
Scenario Outline:
As a logged in user, two connected friend should be able to send facebook messages to each other.
	When Jack sends "<message>" to Barack
	And Jack chooses sticker as "<sticker>"
	And Jack chooses gif as "<gif>"
	And Jack chooses smiley as "<smiley>"
	Then Barack should see "1" notification count upon message icon
	And Barack should see message "<message>"
	When Barack replies back to Jack with "<reply>"
	Then Jack should see Barack's "<reply>" 

	Examples:
	|message|reply|
	|Hi! this is Jack.|Hello Jack, I am Barack, how can I help you?|
	

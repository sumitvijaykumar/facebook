Feature: As a newly signed up user on Facebook, user goes on exploring facebook app and gets started with using facebook.

Background:
	Given user is already logged in

Scenario Outline:
As a logged in user, two connected friend should be able to send facebook messages to each other.
	When Jack sends "<message>" to Barack
	Then Barack should see notification upon message icon
	When Barack replies back to Jack
	Then Jack should see Barack's "<reply>" 
	And Jack should see previously sent "<message>" also

	Examples:
	|message|reply|

@post	
Scenario: User should be able to exchange FB objects such as: Smileys, GIFs and sticker.
	When Jack chooses "<sticker>" 
	And Jack chooses "<gif>"
	And Jack chooses "<smiley>"
	And Jack sends "<message>" to Barack
	Then Barack should see expected "<sticker>" , "<gif>" , "<smiley>" and "<message>" 
	
#	Examples:
#	|sticker|gif|smiley|message|
	

	
	
	
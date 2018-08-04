Feature: As a newly signed up user on Facebook, user goes on exploring facebook app and gets started with using facebook.

Background:
	Given "Jack" is logged in
	And "Barack" is logged in

Scenario:
As a logged in user, user should be able to search a friend on facebook and send him a friend request.
Once the friend approves the friend request, user should see a notification for newly connected friend.

	When Jack searches for a friend having ID "ladee.bhaga.3"
	And Jack sends friend request
	And Barack accepts request from "Jack"
	Then "Jack" should be visible in friend list

@post	
Scenario:
User should be able to make post on friend's wall, like all post and comment on all post.
	Given Jack and Barack are friends
	When Jack visits wall of Barack
	Then Jack should be able to post
	And Jack should be able to like and comment on the post
	When Jack and Barack are not friends
	And Jack visits wall of Barack
	Then Jack should not be able to post to Barack's wall


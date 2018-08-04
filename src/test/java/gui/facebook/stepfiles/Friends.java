package gui.facebook.stepfiles;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Friends {

	@When("^Jack searches for a friend having ID \"([^\"]*)\"$")
	public void jack_searches_for_a_friend_having_ID(String id) {
		Common.loginElements.navigateToUrl("http://www.facebook.com/" + id);
	}

	@When("^Jack sends friend request$")
	public void jack_sends_friend_request() {
		Common.homepageElements.clickButtonAddFriend();
	}

	@When("^Barack accepts request from \"([^\"]*)\"$")
	public void friend_accepts_friend_request(String friendName) {
		Common.friendLoginElements.visitWebApp();
		Common.friendLoginElements.setUsername("ladee.bhaga.3");
		Common.friendLoginElements.setPassword("321#test");
		Common.friendLoginElements.clickLogin();
		Common.friendHomepageElements.acceptFriendRequest(friendName);
	}

	@Then("^\"([^\"]*)\" should be visible in friend list$")
	public void should_be_visible_in_friend_list(String friend) {
		Common.friendProfilePage.clickProfileIcon();
		Assert.assertTrue(Common.friendProfilePage.verifyFriendPresent(friend));
	}

	@Given("^Jack and Barack are friends$")
	public void jack_and_Barack_are_friends() {

	}

	@When("^Jack visits wall of Barack$")
	public void jack_visits_wall_of_Barack() {

	}

	@Then("^Jack should be able to post$")
	public void jack_should_be_able_to_post() {

	}

	@Then("^Jack should be able to like and comment on the post$")
	public void jack_should_be_able_to_like_and_comment_on_the_post() {

	}

	@When("^Jack and Barack are not friends$")
	public void jack_and_Barack_are_not_friends() {

	}

	@Then("^Jack should not be able to post to Barack's wall$")
	public void jack_should_not_be_able_to_post_to_Barack_s_wall() {

	}

}

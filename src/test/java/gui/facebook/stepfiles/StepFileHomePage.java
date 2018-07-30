package gui.facebook.stepfiles;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gui.facebook.config.TestRunner;
import gui.facebook.resources.PageFactoryHome;
import gui.facebook.resources.PageFactoryLogin;
import gui.facebook.resources.PageFactoryProfile;

public class StepFileHomePage {

	PageFactoryLogin loginElements = new PageFactoryLogin(TestRunner.userDriver);
	PageFactoryHome homepageElements = new PageFactoryHome(TestRunner.userDriver);
	PageFactoryLogin friendLoginElements = new PageFactoryLogin(TestRunner.friendDriver);
	PageFactoryHome friendHomepageElements = new PageFactoryHome(TestRunner.friendDriver);
	PageFactoryProfile friendProfilePage = new PageFactoryProfile(TestRunner.friendDriver);

	@Given("^user is already logged in$")
	public void user_is_already_logged_in() throws Throwable {
		loginElements.visitWebApp();
		loginElements.doLogin("sumitpawar0@yahoo.com", "myFb123#");
	}

	@When("^user writes status \"([^\"]*)\"$")
	public void user_writes_status(String string) throws Throwable {
		homepageElements.clickIconHome();
		homepageElements.setStatusText(string);
	}

	@When("^user checks in location \"([^\"]*)\"$")
	public void user_checks_in_location(String location) throws Throwable {
		homepageElements.clickMore();
		homepageElements.setCheckinLocation(location);
	}

	@When("^user tags a \"([^\"]*)\"$")
	public void user_tags_a(String arg1) throws Throwable {
		homepageElements.setTagFriend(arg1);
	}

	@When("^user chooses \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_chooses_as(String activity, String mood) throws Throwable {
		homepageElements.setFeeling(activity);
		homepageElements.setFeelingMood(mood);
	}

	@When("^user posts status$")
	public void user_posts_status() throws Throwable {
		homepageElements.clickButtonPost();
	}

	@Then("^user should see status on home page with \"([^\"]*)\"$")
	public void user_should_see_status_on_home_page_with(String statusText) throws Throwable {
		Assert.assertEquals(homepageElements.getPostedStatusText(), statusText);
	}

	@Then("^status should have \"([^\"]*)\"$")
	public void status_should_have(String statusLocation) throws Throwable {
		Assert.assertEquals(homepageElements.getPostedStatusLocation(), statusLocation);
	}

	@Then("^\"([^\"]*)\" is tagged in the status$")
	public void is_tagged_in_the_status(String taggedFriend) throws Throwable {
		Assert.assertTrue(homepageElements.getPostedStatusFriend().contains(taggedFriend));
	}

	@Then("^status has \"([^\"]*)\" with \"([^\"]*)\"$")
	public void status_has_with(String activity, String mood) throws Throwable {
		homepageElements.getPostedStatusActivity().contains(activity);
		homepageElements.getPostedStatusActivity().contains(mood);
	}

	@When("^Jack searches for a friend having ID \"([^\"]*)\"$")
	public void jack_searches_for_a_friend_having_ID(String id) {
		homepageElements.navigateToUrl("http://www.facebook.com/" + id);
	}

	@When("^Jack sends friend request$")
	public void jack_sends_friend_request() {
		homepageElements.clickButtonAddFriend();
	}

	@When("^Barack accepts request from \"([^\"]*)\"$")
	public void friend_accepts_friend_request(String friendName) {
		friendLoginElements.visitWebApp();
		friendLoginElements.setUsername("ladee.bhaga.3");
		friendLoginElements.setPassword("321#test");
		friendLoginElements.clickLogin();
		friendHomepageElements.acceptFriendRequest(friendName);
	}

	@Then("^\"([^\"]*)\" should be visible in friend list$")
	public void should_be_visible_in_friend_list(String friend) {
		friendProfilePage.clickProfileIcon();
		Assert.assertTrue(friendProfilePage.verifyFriendPresent(friend));
	}

}

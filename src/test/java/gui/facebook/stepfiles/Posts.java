package gui.facebook.stepfiles;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Posts {

	@When("^user writes status \"([^\"]*)\"$")
	public void user_writes_status(String string) {
		Common.homepageElements.clickIconHome();
		Common.homepageElements.setStatusText(string);
	}

	@When("^user checks in location \"([^\"]*)\"$")
	public void user_checks_in_location(String location){
		Common.homepageElements.clickMore();
		Common.homepageElements.setCheckinLocation(location);
	}

	@When("^user tags a \"([^\"]*)\"$")
	public void user_tags_a(String arg1) {
		Common.homepageElements.setTagFriend(arg1);
	}

	@When("^user chooses \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_chooses_as(String activity, String mood) {
		Common.homepageElements.setFeeling(activity);
		Common.homepageElements.setFeelingMood(mood);
	}

	@When("^user posts status$")
	public void user_posts_status() {
		Common.homepageElements.clickButtonPost();
	}

	@Then("^user should see status on home page with \"([^\"]*)\"$")
	public void user_should_see_status_on_home_page_with(String statusText) {
		Assert.assertEquals(Common.homepageElements.getPostedStatusText(), statusText);
	}

	@Then("^status should have \"([^\"]*)\"$")
	public void status_should_have(String statusLocation) {
		Assert.assertEquals(Common.homepageElements.getPostedStatusLocation(), statusLocation);
	}

	@Then("^\"([^\"]*)\" is tagged in the status$")
	public void is_tagged_in_the_status(String taggedFriend) {
		Assert.assertTrue(Common.homepageElements.getPostedStatusFriend().contains(taggedFriend));
	}

	@Then("^status has \"([^\"]*)\" with \"([^\"]*)\"$")
	public void status_has_with(String activity, String mood) {
		Common.homepageElements.getPostedStatusActivity().contains(activity);
		Common.homepageElements.getPostedStatusActivity().contains(mood);
	}

	@When("^user scolls down$")
	public void user_scolls_down() {

	}

	@Then("^user should see older posts automatically loading$")
	public void user_should_see_older_posts_automatically_loading() {

	}

	@Given("^logged in user makes post$")
	public void logged_in_user_makes_post() {

	}

	@When("^user sets privacy of post to \"([^\"]*)\"$")
	public void user_sets_privacy_of_post_to(String arg1) {

	}

	@Then("^friends should not be able to see post$")
	public void friends_should_not_be_able_to_see_post() {

	}

	@When("^user sets privacy to \"([^\"]*)\"$")
	public void user_sets_privacy_to(String arg1) {

	}

	@Then("^only friends should see posts$")
	public void only_friends_should_see_posts() {

	}

	@Then("^non-friend user should not see post$")
	public void non_friend_user_should_not_see_post() {

	}

	@Then("^non-friend user should see the post$")
	public void non_friend_user_should_see_the_post() {

	}

}

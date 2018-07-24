package gui.facebook.stepfiles;

import cucumber.api.java.en.*;
import gui.facebook.resources.PageFactoryHome;
import gui.facebook.resources.PageFactoryLogin;
import junit.framework.Assert;

public class StepFileLogin {

	PageFactoryLogin loginElements = new PageFactoryLogin(Hooks.driver);
	PageFactoryHome homepageElements = new PageFactoryHome(Hooks.driver);

	@SuppressWarnings("deprecation")
	@Given("^user is already logged in$")
	public void user_is_already_logged_in() throws Throwable {
		loginElements.visitWebApp();
		loginElements.setUsername("sumitpawar0@yahoo.com");
		loginElements.setPassword("myFb123#");
		loginElements.clickLogin();
	}

	@When("^user writes status \"([^\"]*)\"$")
	public void user_writes_status(String string) throws Throwable {
		// Assert.assertTrue(homepageElements.getElementStatusBox().isDisplayed());
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
	public void user_should_see_status_on_home_page_with(String arg1) throws Throwable {
	}

	@Then("^status should have \"([^\"]*)\"$")
	public void status_should_have(String arg1) throws Throwable {
	}

	@Then("^\"([^\"]*)\" is tagged in the status$")
	public void is_tagged_in_the_status(String arg1) throws Throwable {
	}

	@Then("^status has \"([^\"]*)\" with \"([^\"]*)\"$")
	public void status_has_with(String arg1, String arg2) throws Throwable {
	}

}

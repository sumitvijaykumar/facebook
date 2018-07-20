package gui.facebook.stepfiles;

import cucumber.api.java.en.*;
import gui.facebook.resources.PageFactoryLogin;

public class StepFileLogin {
	
	PageFactoryLogin loginElements = new PageFactoryLogin(Hooks.driver);

	@Given("^user is already logged in$")
	public void user_is_already_logged_in() throws Throwable {
		loginElements.visitWebApp();
		loginElements.setUsername("sumitpawar0@yahoo.com");
		loginElements.setPassword("testUser123");
		loginElements.clickLogin();
	}

	@When("^user writes status \"([^\"]*)\"$")
	public void user_writes_status(String arg1) throws Throwable {
	}

	@When("^user checks in location \"([^\"]*)\"$")
	public void user_checks_in_location(String arg1) throws Throwable {
	}

	@When("^user tags a \"([^\"]*)\"$")
	public void user_tags_a(String arg1) throws Throwable {
	}

	@When("^user chooses \"([^\"]*)\" as \"([^\"]*)\"$")
	public void user_chooses_as(String arg1, String arg2) throws Throwable {
	}

	@When("^user posts status$")
	public void user_posts_status() throws Throwable {
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

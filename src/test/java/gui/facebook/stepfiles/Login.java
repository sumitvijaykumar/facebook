package gui.facebook.stepfiles;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	@Given("^user sees login page$")
	public void user_sees_login_page()  {
	}

	@When("^user logs in with \"([^\"]*)\"$")
	public void user_logs_in_with(String arg1)  {
	}

	@Then("^user should be logged in for same user$")
	public void user_should_be_logged_in_for_same_user()  {
	}
	
	@When("^user selects \"([^\"]*)\"$")
	public void user_selects(String arg1)  {
	}

	@Then("^user should see login page in \"([^\"]*)\"$")
	public void user_should_see_login_page_in(String arg1)  {
	}
	
}

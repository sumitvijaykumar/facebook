package gui.facebook.stepfiles;

import cucumber.api.java.en.*;

public class Login {

	@Given("^user sees login page$")
	public void user_sees_login_page() {
		Hooks.driver.get("http://www.facebook.com");
	}

	@When("^user enters valid credentials$")
	public void user_enters_valid_credentials() {

	}

	@When("^click on login button$")
	public void click_on_login_button() {
	}

	@Then("^User sees home page$")
	public void user_sees_home_page() {
	}

}

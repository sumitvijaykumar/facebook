package gui.facebook.stepfiles;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Messages {

	@When("^Jack sends \"([^\"]*)\" to Barack$")
	public void user_sends_to_a_friend(String arg1) {
	}

	@Then("^Barack should see notification upon message icon$")
	public void friend_should_see_notification_upon_message_icon() {
	}

	@When("^Barack replies back to Jack$")
	public void friend_replies_back_to_user() {
	}

	@Then("^Jack should see Barack's \"([^\"]*)\"$")
	public void user_should_see_friend_s(String arg1) {
	}

	@Then("^Jack should see previously sent \"([^\"]*)\" also$")
	public void user_should_see_previously_sent_also(String arg1) {
	}
	
	@When("^Jack chooses \"([^\"]*)\"$")
	public void jack_chooses(String arg1)  {
	}

	@Then("^Barack should see expected \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" and \"([^\"]*)\"$")
	public void barack_should_see_expected_and(String arg1, String arg2, String arg3, String arg4)  {
	}

}

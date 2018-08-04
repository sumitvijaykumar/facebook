package gui.facebook.stepfiles;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gui.facebook.Runner.TestRunner;
import gui.facebook.resources.LoginPage;
import gui.facebook.resources.MessagesPage;
import junit.framework.TestResult;

public class Messages {
	
	private LoginPage userLoginElements = new LoginPage(TestRunner.userDriver);
	private MessagesPage userElement = new MessagesPage(TestRunner.userDriver);
	private MessagesPage friendElement = new MessagesPage(TestRunner.friendDriver);
	
	private long timeStampMessage=System.currentTimeMillis();
	
	@When("^Jack sends \"([^\"]*)\" to Barack$")
	public void user_sends_to_a_friend(String msg) {
		userElement.sendMessage("Barack", msg);
	}

	@Then("^Barack should see \"([^\"]*)\" notification count upon message icon$")
	public void friend_should_see_notification_upon_message_icon(String notificationCount) {
		friendElement.checkNewMessageCount(notificationCount);
	}
	
	@Then("^Barack should see message \"([^\"]*)\"$")
	public void friend_should_receive_message(String message) {
		friendElement.openLatestMessage();
		friendElement.checkNewMessageBody(message);
	}

	@When("^Barack replies back to Jack with \"([^\"]*)\"$")
	public void friend_replies_back_to_user(String reply) {
		friendElement.sendMessage(reply);
	}

	@Then("^Jack should see Barack's \"([^\"]*)\"$")
	public void user_should_see_friend_s(String reply) {
		//userElement.openLatestMessage();
		userElement.checkNewMessageBody(reply);
	}

//	@Then("^Jack should see previously sent \"([^\"]*)\" also$")
//	public void user_should_see_previously_sent_also(String arg1) {
//	}
	
	@When("^Jack chooses sticker as \"([^\"]*)\"$")
	public void jack_chooses_sticker(String sticker)  {
		
	}
	
	@When("^Jack chooses gif as \"([^\"]*)\"$")
	public void jack_chooses_gif(String sticker)  {
		
	}
	
	@When("^Jack chooses smiley as \"([^\"]*)\"$")
	public void jack_chooses_smiley(String sticker)  {
		
	}

}

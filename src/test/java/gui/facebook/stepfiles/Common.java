package gui.facebook.stepfiles;

import cucumber.api.java.en.Given;
import gui.facebook.Runner.TestRunner;
import gui.facebook.resources.HomePage;
import gui.facebook.resources.LoginPage;
import gui.facebook.resources.ProfilePage;

public class Common {
	public static LoginPage loginElements = new LoginPage(TestRunner.userDriver);
	public static HomePage homepageElements = new HomePage(TestRunner.userDriver);
	public static LoginPage friendLoginElements = new LoginPage(TestRunner.friendDriver);
	public static HomePage friendHomepageElements = new HomePage(TestRunner.friendDriver);
	public static ProfilePage friendProfilePage = new ProfilePage(TestRunner.friendDriver);
	
	@Given("^user is already logged in$")
	public void user_is_already_logged_in() throws Throwable {
		loginElements.visitWebApp();
		loginElements.doLogin("sumitpawar0@yahoo.com", "myFb123#");
	}

}

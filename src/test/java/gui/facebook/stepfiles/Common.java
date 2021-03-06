package gui.facebook.stepfiles;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.java.en.Given;
import gui.facebook.Runner.TestRunner;
import gui.facebook.resources.HomePage;
import gui.facebook.resources.LoginPage;
import gui.facebook.resources.ProfilePage;

public class Common {
	
	public static Logger logsCommon = LogManager.getLogger(Common.class.getClass());
	
	public static LoginPage loginElements = new LoginPage(TestRunner.userDriver);
	public static HomePage homepageElements = new HomePage(TestRunner.userDriver);
	public static LoginPage friendLoginElements = new LoginPage(TestRunner.friendDriver);
	public static HomePage friendHomepageElements = new HomePage(TestRunner.friendDriver);
	public static ProfilePage friendProfilePage = new ProfilePage(TestRunner.friendDriver);

	@Given("^\"([^\"]*)\" is logged in$")
	public void user_is_already_logged_in(String user) throws Throwable {
		
		if (user.equalsIgnoreCase("Jack")) {
			loginElements.visitWebApp();
			loginElements.doLogin("sumitpawar0@yahoo.com", "myFb123#");
		} else if (user.equalsIgnoreCase("Barack")) {
			friendLoginElements.visitWebApp();
			friendLoginElements.doLogin("ladee.bhaga.3", "321#test");
		}
		else{
			logsCommon.info("Invalid user. Jack is primary user. Barack is friend user.");
		}
	}
	
	public void getCurrentTimeStamp(){
		long milliSec=System.currentTimeMillis();
		String stringMillis = Long.toString(milliSec);
	}
}

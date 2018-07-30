package gui.facebook.resources;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryProfile {
	WebDriver driver;
	
	public static final Logger logsProfilePage = LogManager.getLogger(PageFactoryProfile.class.getName());
	
	public PageFactoryProfile(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logsProfilePage.info("Profile page factory elements initialized.");
	}
	
	@FindBy(id="profile_timeline_tiles_unit_pagelets_friends")
	WebElement divFriendList;
	
	@FindBy(xpath=".//a[@title='Profile']")
	WebElement iconProfile;
	
	@FindAll({@FindBy(xpath=".//a[@aria-label='Story options']")})
	List<WebElement> optionButtons;
	
	@FindBy(xpath=".//a[@data-feed-option-name='FeedDeleteOption']")
	WebElement buttonFeedDelete;
	
	public void clickProfileIcon(){
		iconProfile.click();
	}

	public boolean verifyFriendPresent(String friend){
		logsProfilePage.info("Friend list contains:"+divFriendList.getText());
		return 	divFriendList.getText().contains(friend);
	}
/*	
	public removeAllFriend(){
	}
	
*/	
	
}

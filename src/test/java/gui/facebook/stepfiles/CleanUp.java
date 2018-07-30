package gui.facebook.stepfiles;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import gui.facebook.resources.PageFactoryProfile;

public class CleanUp {

	WebDriver driver;

	public static final Logger logsCleanUp = LogManager.getLogger(PageFactoryProfile.class.getName());

	public CleanUp(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logsCleanUp.info("Clean up elements initialized.");
	}

	@FindBy(xpath = ".//a[@aria-label='Story options']")
	WebElement optionButton;

	@FindBy(xpath=".//div[@id='profile_timeline_tiles_unit_pagelets_friends']//table//a")
	List<WebElement> linkFriends;
	
	@FindBy(xpath = ".//a[@data-feed-option-name='FeedDeleteOption']")
	WebElement buttonFeedDelete;

	@FindBy(xpath = ".//a[@data-feed-option-name='HIDE']")
	WebElement buttonFeedHide;

	@FindBy(xpath = ".//button[contains(@class,'layerConfirm uiOverlayButton')]")
	WebElement buttonConfirmDeletePost;

	@FindBy(xpath = ".//a[@title='Profile']")
	WebElement iconProfile;

	@FindBy(xpath = ".//img[@alt='your profile photo']")
	WebElement profilePicture;
	
	@FindBy(xpath=".//a[contains(@class,'friendButton')]")
	WebElement buttonFriends;
	
	@FindBy(xpath = ".//button[contains(@class,'FriendRequestAdd')]")
	WebElement buttonAddFriend;
	
	@FindBy(xpath=".//li[@data-label='Unfriend']")
	WebElement optionUnfriend;
	
	public void deleteAllFriends(){
		//ArrayList<String> friendName = new ArrayList<String>();
				
		try{
			iconProfile.click();
			profilePicture.isDisplayed();
			int friendCount = linkFriends.size();
			logsCleanUp.info(friendCount);
			WebDriverWait wait = new WebDriverWait(this.driver, 10);
			while(friendCount > 0){
				iconProfile.click();
				linkFriends.get(1).click();
				buttonFriends.click();
				wait.until(ExpectedConditions.visibilityOf(optionButton));
				optionUnfriend.click();
				wait.until(ExpectedConditions.visibilityOf(buttonAddFriend));
			}
				//wait.until(ExpectedConditions.visibilityOf(friend));
				//System.out.println(friend.isDisplayed());
				//logsCleanUp.info(linkFriends.size() + "Friend(s) present. Deleting all.");		
				//friend.click();
			}
		catch(Exception e){
			
		}
	}

	public void deleteAllPosts() {
		try {
			iconProfile.click();
			profilePicture.isDisplayed();
			optionButton.click();
			try {
				buttonFeedDelete.click();
			} catch (Exception e) {
				buttonFeedHide.click();
			}
			buttonConfirmDeletePost.click();
			logsCleanUp.info("Feed deleted");

		} catch (Exception e) {
			logsCleanUp.error("Unable to delete posts.");
		}
	}
}

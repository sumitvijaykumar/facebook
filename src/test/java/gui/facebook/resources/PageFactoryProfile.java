package gui.facebook.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
	
	public void clickProfileIcon(){
		iconProfile.click();
	}

	public boolean verifyFriendPresent(String friend){
		return 	divFriendList.getText().contains(friend);
	}
}

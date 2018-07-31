package gui.facebook.resources;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gui.facebook.Runner.DriverUtilities;
import gui.facebook.Runner.TestRunner;

public class HomePage {
	WebDriver driver;

	private static final Logger logsHomePage = LogManager.getLogger(HomePage.class.getName());

	@FindBy(xpath = ".//div[@data-click='home_icon']")
	WebElement iconHome;

	@FindBy(xpath = ".//div[@data-click='profile_icon']")
	WebElement iconProfile;

	@FindBy(xpath = ".//textarea[@name='xhpc_message']")
	WebElement textBoxStatus;

	@FindBy(xpath = ".//span[text()='Post']")
	WebElement buttonPost;

	@FindBy(xpath = ".//div[@aria-label='News Feed']/div[@role='article'][1]")
	WebElement recentPost;

	@FindBy(xpath = ".//div[@aria-label='News Feed']/div[@role='article'][1]//p")
	WebElement recentPostText;

	@FindBy(xpath = ".//div[@aria-label='News Feed']/div[@role='article'][1]//h5//span/span")
	WebElement textRecentPostActivityMood;

	@FindBy(xpath = ".//div[@aria-label='News Feed']/div[@role='article'][1]//h5/span/span/a[1]")
	WebElement textRecentPostTaggedFriend;

	@FindBy(xpath = ".//div[@aria-label='News Feed']/div[@role='article'][1]//h5/span/span/a[2]")
	WebElement textRecentPostLocation;

	@FindBy(xpath = ".//div[@aria-label='News Feed']/div[@role='article'][1]//h5/span/span/span/a[1]")
	WebElement linkUserInTimeline;

	@FindBy(xpath = "(.//a[@aria-label='Story options'])[1]")
	WebElement buttonStoryOption;

	@FindBy(xpath = ".//a[@data-feed-option-name='FeedDeleteOption']")
	WebElement buttonStoryDelete;

	@FindBy(xpath = ".//div[@data-tooltip-content='Photo/Video']")
	WebElement buttonPhotosVideos;

	@FindBy(xpath = ".//div[@data-tooltip-content='Feeling/Activity']")
	WebElement buttonFeeling;

	@FindBy(xpath = ".//div[@data-testid='ellipsis-sprout']")
	WebElement buttonStatusMore;

	@FindBy(xpath = ".//div[@data-tooltip-content='Tag friends']")
	WebElement buttonTagFriends;

	@FindBy(xpath = ".//div[@data-tooltip-content='Check in']")
	WebElement buttonCheckin;

	@FindBy(xpath = ".//input[@placeholder='Choose a feeling or activity...']")
	WebElement textboxFeeling;

	@FindBy(xpath = ".//input[@placeholder='Where are you?']")
	WebElement textboxCheckin;

	@FindBy(xpath = ".//input[@placeholder='Who are you with?']")
	WebElement textboxFriends;

	@FindBy(xpath = ".//span[@class='withToken']")
	WebElement linkSelectedFriend;

	@FindBy(xpath = ".//div[@class='uiScrollableAreaBody']//ul/li[@aria-selected='true']")
	WebElement listSelected;

	@FindBy(xpath = ".//ul[@role='listbox']/li[1]")
	WebElement listFirstElement;

	@FindBy(xpath = ".//tbody/tr/td/span//input")
	WebElement textboxMood;

	@FindBy(xpath = ".//button[contains(@class,'FriendRequestAdd')]")
	WebElement buttonAddFriend;
	
	@FindBy(xpath=".//div[contains(@class,'friendConfirmed')]")
	WebElement spanFriendConfirmed;
	
	@FindBy(xpath=".//a[@data-tooltip-content='Friend requests']")
	WebElement iconFriend;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logsHomePage.info("Home page factory initialized.");
	}

	public void reloadPage() {
		driver.navigate().refresh();
	}

	public void clickIconHome() {
		iconHome.click();
	}

	public void clickIconProfile() {
		iconProfile.click();
	}

	public WebElement getElementStatusBox() {
		return textBoxStatus;
	}

	public void setStatusText(String status){
		this.reloadPage();
		textBoxStatus.sendKeys(status);
	}

	public void setFeeling(String feeling) {
		try {
			buttonFeeling.click();
			textboxFeeling.sendKeys(feeling);
			listFirstElement.click();
		} catch (Exception e) {
			logsHomePage.error("Not able to set activity.");
		}
	}

	public void setFeelingMood(String mood)  {
		try {
			textboxMood.sendKeys(mood);
			Thread.sleep(1000); // TODO Remove thread.sleep
			listFirstElement.click();
		} catch (Exception e) {
			logsHomePage.error("Not able to set activity.");
		}
	}

	public void clickMore() {
		buttonStatusMore.click();
	}

	public void setTagFriend(String friend) {
		try {
			buttonTagFriends.click();
			textboxFriends.sendKeys(friend);
			textboxFriends.sendKeys(Keys.RETURN);
			linkSelectedFriend.getText().contains(friend);
		} catch (Exception e) {
			logsHomePage.error("Selected friend link not found on compose dialog box.");
		}
	}

	public void setCheckinLocation(String location) {
		try{
			buttonCheckin.click();
			textboxCheckin.sendKeys(location);
			Thread.sleep(3000); // TODO Remove thread.sleep
			listFirstElement.click();
		}catch(Exception e){
			logsHomePage.error("Not able to set check in location.");
		}
	}

	public void clickButtonPost() {
		try{
			buttonPost.click();
			WebDriverWait wait = new WebDriverWait(this.driver, 5);
			wait.until(ExpectedConditions.visibilityOf(recentPost));
		}catch(Exception e){
			logsHomePage.error("Posted status not visible.");
		}
		
	}

	public String getPostedStatusText() {
		String postedText = recentPostText.getText();
		return postedText;
	}

	public String getPostedStatusFriend() {
		String taggedFriend="";
		try{
			taggedFriend = textRecentPostTaggedFriend.getText();
		}catch(Exception e){
			logsHomePage.error("Friend is not tagged in the post.");
		}
		return taggedFriend;
	}

	public String getPostedStatusLocation() {
		String location = textRecentPostLocation.getText();
		return location;
	}

	public String getPostedStatusActivity() {
		String activity = textRecentPostActivityMood.getText();
		return activity;
	}

	public void deleteLastPosts() {
		if (linkUserInTimeline.getText() == "Jack Jackals") {
			buttonStoryOption.click();
			buttonStoryDelete.click();
		}
	}

	public void navigateToUrl(String url) {
		driver.get(url);
	}

	public void clickButtonAddFriend() {
		try{
			buttonAddFriend.click();
		}catch(Exception e){
			logsHomePage.warn("Add friend button not found");
		}
	}
	
	public void clickIconFriend(){
		iconFriend.click();
	}
	
	public void acceptFriendRequest(String friendName){
		try{
			clickIconFriend();
			WebElement buttonAccept=driver.findElement(By.xpath(".//a[contains(text(),'"+friendName+"')]//ancestor::div[@class='clearfix']//button[contains(text(), 'Confirm')]"));
			buttonAccept.click();
			spanFriendConfirmed.isDisplayed();
		}catch(Exception e){
			logsHomePage.error("Could not accept incoming request from friend login.");
		}
	}
}

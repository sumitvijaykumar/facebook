package gui.facebook.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageFactoryHome {
	WebDriver driver;
	
	@FindBy(xpath=".//div[@data-click='home_icon']")
	WebElement iconHome;
	
	@FindBy(xpath=".//div[@data-click='profile_icon']")
	WebElement iconProfile;

	@FindBy(xpath=".//textarea[@name='xhpc_message']")
	WebElement textBoxStatus;
	
	@FindBy(xpath=".//span[text()='Post']")
	WebElement buttonPost;
	
	@FindBy(xpath=".//div[@aria-label='News Feed']/div[@role='article'][1]")
	WebElement recentPost;

	@FindBy(xpath=".//div[@aria-label='News Feed']/div[@role='article'][1]//p")
	WebElement recentPostText;
	
	@FindBy(xpath=".//div[@aria-label='News Feed']/div[@role='article'][1]//h5//span/span")
	WebElement textRecentPostActivityMood;

	@FindBy(xpath=".//div[@aria-label='News Feed']/div[@role='article'][1]//h5/span/span/a[1]")
	WebElement textRecentPostTaggedFriend;

	@FindBy(xpath=".//div[@aria-label='News Feed']/div[@role='article'][1]//h5/span/span/a[2]")
	WebElement textRecentPostLocation;
	
	@FindBy(xpath=".//div[@aria-label='News Feed']/div[@role='article'][1]//h5/span/span/span/a[1]")
	WebElement linkUserInTimeline;
	
	@FindBy(xpath="(.//a[@aria-label='Story options'])[1]")
	WebElement buttonStoryOption;
	
	@FindBy(xpath=".//a[@data-feed-option-name='FeedDeleteOption']")
	WebElement buttonStoryDelete;

	@FindBy(xpath=".//div[@data-tooltip-content='Photo/Video']")
	WebElement buttonPhotosVideos;
	
	@FindBy(xpath=".//div[@data-tooltip-content='Feeling/Activity']")
	WebElement buttonFeeling;
	
	@FindBy(xpath=".//div[@data-testid='ellipsis-sprout']")
	WebElement buttonStatusMore;
	
	@FindBy(xpath=".//div[@data-tooltip-content='Tag friends']")
	WebElement buttonTagFriends;
	
	@FindBy(xpath=".//div[@data-tooltip-content='Check in']")
	WebElement buttonCheckin;
	
	@FindBy(xpath=".//input[@placeholder='Choose a feeling or activity...']")
	WebElement textboxFeeling;
	
	@FindBy(xpath=".//input[@placeholder='Where are you?']")
	WebElement textboxCheckin;
	
	@FindBy(xpath=".//input[@placeholder='Who are you with?']")
	WebElement textboxFriends;
	
	@FindBy(xpath=".//div[@class='uiScrollableAreaBody']//ul/li[@aria-selected='true']")
	WebElement listSelected;
	
	@FindBy(xpath=".//ul[@role='listbox']/li[1]")
	WebElement listFirstElement;
	
	@FindBy(xpath=".//tbody/tr/td/span//input")
	WebElement textboxMood;
	
	public PageFactoryHome(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void reloadPage(){
		driver.navigate().refresh();
	}
	
	public void clickIconHome(){
		iconHome.click();
	}
	
	public void clickIconProfile(){
		iconProfile.click();
		
	}
	
	public WebElement getElementStatusBox(){
		return textBoxStatus;
	}
	
	public void setStatusText(String status) throws InterruptedException{
		textBoxStatus.sendKeys(status);
	}
	
	public void setFeeling(String feeling){
		buttonFeeling.click();
		textboxFeeling.sendKeys(feeling);
		listFirstElement.click();
		
	}
	
	public void setFeelingMood(String mood) throws InterruptedException{
		textboxMood.sendKeys(mood);
		Thread.sleep(1000); //TODO Remove thread.sleep
		listFirstElement.click();
	}
	
	public void clickMore() throws InterruptedException{
		buttonStatusMore.click();
	}
	
	public void setTagFriend(String friend) throws InterruptedException{
		buttonTagFriends.click();
		textboxFriends.sendKeys(friend);
		textboxFriends.sendKeys(Keys.RETURN);
	}
	
	public void setCheckinLocation(String location) throws InterruptedException{
		buttonCheckin.click();
		textboxCheckin.sendKeys(location);
		Thread.sleep(3000); //TODO Remove thread.sleep
		listFirstElement.click();
	}
	
	public void clickButtonPost(){
		buttonPost.click();
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		wait.until(ExpectedConditions.visibilityOf(recentPost));
	}
	
	public String getPostedStatusText() throws InterruptedException{
		String postedText = recentPostText.getText();
		return postedText;
	}
	
	public String getPostedStatusFriend(){
		String taggedFriend = textRecentPostTaggedFriend.getText();
		return taggedFriend;
	}
	
	public String getPostedStatusLocation(){
		String location = textRecentPostLocation.getText();
		return location;
	}
	
	public String getPostedStatusActivity(){
		String activity = textRecentPostActivityMood.getText();
		return activity;
	}
	
	public void deleteLastPosts(){
		if(linkUserInTimeline.getText()=="Jack Jackals"){
			buttonStoryOption.click();
			buttonStoryDelete.click();
		}
	}
}

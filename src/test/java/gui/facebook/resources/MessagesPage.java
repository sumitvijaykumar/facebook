package gui.facebook.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagesPage {
	
	WebDriver driver;
	
	public static final Logger logsMessages = LogManager.getLogger(MessagesPage.class.getName());
	
	public MessagesPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logsMessages.info("Web elements for messages intialized.");
	}
	
	@FindBy(xpath=".//a[@data-tooltip-content='Messages']")
	WebElement iconMessage;

	@FindBy(xpath=".//div[@role='dialog']//a[text()='New Message']")
	WebElement linkNewMessage;
	
	@FindBy(xpath=".//div[@id='pagelet_timeline_profile_actions']//a[text()='Message']")
	WebElement buttonMessage;
	
	@FindBy(xpath=".//input[@class='inputtext textInput']")
	WebElement textBoxTo;
	
	@FindBy(xpath=".//div[contains(@class,'clearfix uiTokenizer')]")
	WebElement divTo;
	
	@FindBy(xpath=".//div[contains(@class,'uiTypeaheadView')]//li[contains(@title,'Barack')]")
	WebElement textBoxToBarack;

	@FindBy(xpath=".//div[contains(@class,'notranslate')]")
	WebElement textBoxMessageBox;
	
	@FindBy(xpath=".//a[@title='Choose a sticker']")
	WebElement iconMessageSticker;
	
	@FindBy(xpath=".//a[@title='Choose a GIF']")
	WebElement iconMessageGif;
	
	@FindBy(xpath=".//a[@title='Choose an emoji']")
	WebElement iconMessageEmoji;
	
	@FindBy(xpath=".//a[@label='Send']")
	WebElement buttonMessageSend;
	
	@FindBy(xpath=".//table[contains(@class,'conversationContainer')]")
	WebElement messageContainer;
	
	@FindBy(xpath=".//a[@class='fbNubButton']")
	WebElement chatBox;

	@FindBy(xpath=".//a[@name='mercurymessages']")
	WebElement messageIconCount;
	
	@FindBy(xpath=".//li[@class='jewelItemNew']//strong/span")
	WebElement newMessageUserName;
	
	@FindBy(className="timestamp")
	WebElement newMessageTime;
	
	@FindBy(xpath=".//div[@class='uiScrollableAreaBody']//li[@class='jewelItemNew']")
	WebElement listLatestMessage;
	
	
	public void sendMessage(String friendName, String message){
		iconMessage.click();
		linkNewMessage.click();
		Actions builder = new Actions(this.driver);
		Action selectRecipient = builder.moveToElement(divTo).click().sendKeys(friendName).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build();
		selectRecipient.perform();
		Action sendMessage = builder.moveToElement(textBoxMessageBox).click().sendKeys(message).sendKeys(Keys.ENTER).build();
		sendMessage.perform();
	}
	
	public void sendMessage(String reply){
		iconMessage.click();
		listLatestMessage.click();
		Actions builder = new Actions(this.driver);
		Action sendMessage = builder.moveToElement(textBoxMessageBox).click().sendKeys(reply).sendKeys(Keys.ENTER).build();
		sendMessage.perform();
	}
	
	public void checkNewMessageCount(String count){
		logsMessages.info(messageIconCount.getText());
		messageIconCount.getText().contains(count);
	}
	
	public void checkNewMessageBody(String message){
		logsMessages.info(messageContainer.getText());
		messageContainer.getText().contains(message);
		
	}
	
	public void openLatestMessage(){
		iconMessage.click();
		listLatestMessage.click();
	}

	
}

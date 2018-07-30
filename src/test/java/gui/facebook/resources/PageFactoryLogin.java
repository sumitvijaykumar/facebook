package gui.facebook.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLogin {
	WebDriver driver;
	
	private static final Logger logsLoginPage = LogManager.getLogger(PageFactoryHome.class.getName());
	
	@FindBy(id="email")
	WebElement textBoxEmail;
	
	@FindBy(id="pass")
	WebElement textBoxPassword;
	
	@FindBy(id="loginbutton")
	WebElement buttonLogin;
	
	public PageFactoryLogin(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void visitWebApp(){
		driver.get("http://www.facebook.com");
	}
	
	public void setUsername(String username){
		textBoxEmail.sendKeys(username);
	}
	
	public void setPassword(String password){
		textBoxPassword.sendKeys(password);
	}

	public void clickLogin(){
		buttonLogin.click();
	}
	
	public void doLogin(String uname, String pwd){
		try{
			setUsername(uname);
			setPassword(pwd);
			clickLogin();
		}catch(Exception e){
			logsLoginPage.info("Could not find expected elements for login. User might be already logged in.");
		}
	}
}

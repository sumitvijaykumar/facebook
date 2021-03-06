package gui.facebook.resources;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	private static final Logger logsLoginPage = LogManager.getLogger(HomePage.class.getName());
	
	@FindBy(id="email")
	WebElement textBoxEmail;
	
	@FindBy(id="pass")
	WebElement textBoxPassword;
	
	@FindBy(id="loginbutton")
	WebElement buttonLogin;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		logsLoginPage.info("Login page factory elements initialized");
	}
	
	public void navigateToUrl(String url) {
		driver.get(url);
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
			logsLoginPage.info("Logging in with user: "+uname);
			setUsername(uname);
			setPassword(pwd);
			clickLogin();
		}catch(Exception e){
			logsLoginPage.info("Could not find expected elements for login. User might be already logged in.");
		}
	}
}

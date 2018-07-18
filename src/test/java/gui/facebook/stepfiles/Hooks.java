package gui.facebook.stepfiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void configBrowser() {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\gui\\facebook\\resources\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "src\\test\\java\\gui\\facebook\\resources\\geckodriver.exe");
		String browser = System.getProperty("browser");
		if (browser==null){
			browser = System.getenv("browser");
			if (browser==null){
				browser = "firefox";
			}
		}
		
		if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("ff")){
			driver = new FirefoxDriver();
		}
		
		else{
			System.out.println("invalid browser type:"+ browser);
		}
		
		driver.manage().deleteAllCookies();
		
	}
	
	@After
	public void getScreenShot(){
		System.out.println("Getting screenshot");
		driver.quit();
	}
	
}

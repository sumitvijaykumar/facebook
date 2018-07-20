package gui.facebook.stepfiles;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void configBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\gui\\facebook\\resources\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "src\\test\\java\\gui\\facebook\\resources\\geckodriver.exe");
		String browser = System.getProperty("browser");
		if (browser==null){
			browser = System.getenv("browser");
			if (browser==null){
				browser = "ff";
			}
		}
		
		if(browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			/*DesiredCapabilities cap = DesiredCapabilities.chrome();
			driver = new RemoteWebDriver(new URL("http://34.205.159.86:4446/wd/hub"), cap);*/
		}
		
		else if(browser.equalsIgnoreCase("ff")){
			driver = new FirefoxDriver();
			/*DesiredCapabilities cap = DesiredCapabilities.firefox();
			driver = new RemoteWebDriver(new URL("http://34.205.159.86:4446/wd/hub"), cap);*/
		}
		
		else{
			System.out.println("invalid browser type:"+ browser);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@After
	public void getScreenShot(){
		System.out.println("Screenshot logic here");
		driver.quit();
	}
	
}

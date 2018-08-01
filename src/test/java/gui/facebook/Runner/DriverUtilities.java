package gui.facebook.Runner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;

public class DriverUtilities {
	private final static Logger logHooks = LogManager.getLogger(DriverUtilities.class.getName());
	private WebDriver driver;

	public void configDriver()  {
		try{
		System.setProperty("webdriver.chrome.driver","src\\test\\java\\gui\\facebook\\resources\\browserDrivers\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","src\\test\\java\\gui\\facebook\\resources\\browserDrivers\\geckodriver.exe");
		System.setProperty("log4j.configurationFile","src\\test\\java\\gui\\facebook\\reports\\log4j2.xml");
		}catch(Exception e){
			logHooks.error("Not able to set system properties. Check path to system variables.");
		}
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = System.getenv("browser");
			if (browser == null) {
				browser = "chrome";
			}
		}
		try{
		if (browser.equalsIgnoreCase("chrome")) {
			
/*			ChromeOptions disableNotifications = new ChromeOptions();
			disableNotifications.addArguments("--disable-notifications");
			this.driver = new ChromeDriver(disableNotifications);
*/			
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName("Chrome");
			this.driver = new RemoteWebDriver(new URL("http://18.204.194.238:4446/wd/hub"),cap);
			logHooks.info("remote web driver for chrome initialized.");
		}

		else if (browser.equalsIgnoreCase("ff")) {
			
/*			FirefoxOptions disableNotifications = new FirefoxOptions();
			disableNotifications.addArguments("--disable-notifications");
			this.driver = new FirefoxDriver(disableNotifications);
*/			
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			this.driver = new RemoteWebDriver(new URL("http://18.204.194.238:4446/wd/hub"), cap);
			logHooks.info("remote web driver for firefox initialized.");
		}

		else {
			System.out.println("invalid browser type:" + browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}catch(MalformedURLException e){
			logHooks.error("Could not initialize remote driver.");
		}catch(Exception e){
			logHooks.error("Could not initialize driver.");
		}
	}

	public void takeScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			if (this.driver instanceof TakesScreenshot) {
				TakesScreenshot camera = (TakesScreenshot) this.driver;
				byte[] screenshot = camera.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		}
	}
	
	public WebDriver getWebDriver(){
		this.configDriver();
		logHooks.info("returning web driver object:"+driver.toString());
		return this.driver;
	}
	
	
}

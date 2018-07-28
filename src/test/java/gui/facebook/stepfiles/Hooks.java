package gui.facebook.stepfiles;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver driver;
	public static WebDriver driverFriend; //for accepting friend request

	@Before
	public void configBrowser() throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "src\\test\\java\\gui\\facebook\\resources\\chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "src\\test\\java\\gui\\facebook\\resources\\geckodriver.exe");
		System.setProperty("log4j.configurationFile","src\\test\\java\\gui\\facebook\\reports\\log4j2.xml");
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = System.getenv("browser");
			if (browser == null) {
				browser = "chrome";
			}
		}

		if (browser.equalsIgnoreCase("chrome")) {
			ChromeOptions disableNotifications = new ChromeOptions();
			disableNotifications.addArguments("--disable-notifications");
			driver = new ChromeDriver(disableNotifications);
			/*
			 * DesiredCapabilities cap = DesiredCapabilities.chrome(); driver =
			 * new RemoteWebDriver(new URL("http://34.205.159.86:4446/wd/hub"),
			 * cap);
			 */
		}

		else if (browser.equalsIgnoreCase("ff")) {
			FirefoxOptions disableNotifications = new FirefoxOptions();
			disableNotifications.addArguments("--disable-notifications");
			driver = new FirefoxDriver(disableNotifications);
			/*
			 * DesiredCapabilities cap = DesiredCapabilities.firefox(); driver =
			 * new RemoteWebDriver(new URL("http://34.205.159.86:4446/wd/hub"),
			 * cap);
			 */
		}

		else {
			System.out.println("invalid browser type:" + browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void getScreenShot() {

		System.out.println("Screenshot logic here");

	}

	@After
	public void takeScreenShot(Scenario scenario) {
		if (scenario.isFailed()) {
			if (driver instanceof TakesScreenshot) {
				TakesScreenshot camera = (TakesScreenshot) driver;
				byte[] screenshot = camera.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		}
	}
}

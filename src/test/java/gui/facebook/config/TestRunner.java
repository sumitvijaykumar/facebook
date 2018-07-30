package gui.facebook.config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gui.facebook.reports.ReportGeneration;
import gui.facebook.stepfiles.CleanUp;
import gui.facebook.stepfiles.Hooks;

@CucumberOptions(
		features = "src/test/java/gui/facebook/features", 
		glue = { "gui.facebook.stepfiles" },
		tags={"@post"},
		format= {
				"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/rerun.txt"
		})

public class TestRunner {
	
	public static WebDriver userDriver;
	public static WebDriver friendDriver;
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun=true)
	public void setUpClass(){
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		userDriver = new Hooks().getWebDriver();
		friendDriver = new Hooks().getWebDriver();
	}
	
	@Test(groups = "cucumber", description = "Cucumber feature file runner", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature){
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
	}
	@After
	public void test(){
		System.out.println("after the test.");
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass(){
		CleanUp cleanUp = new CleanUp(userDriver);
		cleanUp.deleteAllFriends();
		cleanUp.deleteAllPosts();
		testNGCucumberRunner.finish();
		new ReportGeneration();
		userDriver.quit();
		friendDriver.quit();
	}
	
	
}
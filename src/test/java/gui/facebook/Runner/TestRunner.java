package gui.facebook.Runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gui.facebook.reports.ReportGeneration;
import gui.facebook.resources.Utilities;

@RunWith(Cucumber.class)
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
		userDriver = new DriverUtilities().getWebDriver();
		friendDriver = new DriverUtilities().getWebDriver();
	}
	
	@Test(groups = "cucumber", description = "Cucumber feature file runner", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature){
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}
	
	@DataProvider
	public Object[][] features(){
		return testNGCucumberRunner.provideFeatures();
	}
	@BeforeTest
	public void test(){
		System.out.println("before the test.");
	}
	
	@AfterTest
	public void saveScreenShot(Scenario scenario){
		new DriverUtilities().takeScreenShot(scenario);
	}
	
	@AfterClass(alwaysRun = true)
	public void tearDownClass(){
		Utilities cleanUp = new Utilities(userDriver);
		cleanUp.deleteAllFriends();
		cleanUp.deleteAllPosts();
		testNGCucumberRunner.finish();
		new ReportGeneration();
		userDriver.quit();
		friendDriver.quit();
	}
	
	
}
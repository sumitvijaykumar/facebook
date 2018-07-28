package gui.facebook.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class ReportGeneration {
	
	public ReportGeneration(){
		File reportOutputDir = new File("target/cucumber-reports");
		List<String> jsonFileReports = new ArrayList<String>();
		jsonFileReports.add("target/cucumber-reports/CucumberTestReport.json");
		
		String buildNumber = "1";
		String projectName = "Facebook Automation Test";
		boolean runWithJenkins = false;
		boolean parallelTesting = false;
		
		Configuration conf = new Configuration(reportOutputDir, projectName);
		conf.setParallelTesting(parallelTesting);
		conf.setRunWithJenkins(runWithJenkins);
		conf.setBuildNumber(buildNumber);
		
		conf.addClassifications("Platform", "Windows");
		conf.addClassifications("Browser","Firefox");
		conf.addClassifications("Branch", "release");
		
		ReportBuilder reportbuilder = new ReportBuilder(jsonFileReports, conf);
		Reportable result = reportbuilder.generateReports();
		
	}
	
}

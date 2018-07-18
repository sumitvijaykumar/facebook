package gui.facebook.config;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/gui/facebook/features", glue = { "gui.facebook.stepfiles" })
public class TestRunner {

}
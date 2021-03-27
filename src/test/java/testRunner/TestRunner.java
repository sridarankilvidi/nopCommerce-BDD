package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features=".//Features//Customers.feature",	
		glue={"stepDefinitions"},
		dryRun = false,
		plugin = { "pretty", "json:target/Cucumber.json",
				 "junit:target/Cucumber.xml",
				 "html:target/cucumber-reports"},
		monochrome=true
		)
public class TestRunner {
		
}

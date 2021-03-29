package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features= {".//Features/"},	
		glue={"stepDefinitions"},
		monochrome=true,
		dryRun = false,
		plugin = { "pretty", "json:target/Cucumber.json",
				 "junit:target/Cucumber.xml",
				 "html:target/cucumber-reports.html"},
	// or operator: tags= "@sanity or @regression" -sanity tag or regression tag scenarios will be run
	// and operator: tags= "@sanity and @regression" - only scenarios with both sanity and regression tags will BE RUN
	// tags= "@sanity"  - only SANITY tag will be run
		tags= "@sanity or @regression"
		)
public class TestRunner {
		
}


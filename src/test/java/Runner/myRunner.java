package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Users/Sheharyar Jafri/Desktop/CucumberJavaDevTools/src/test/resources/Features", 
glue = {
		"StepDefinition" }, plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
				"junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports.html"},
				monochrome = true)

public class myRunner {

}

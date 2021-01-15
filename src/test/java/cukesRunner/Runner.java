package cukesRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json"},
        features = "src/test/resources",
        glue = "stepDefinition",
        tags = "@TEC-1010",
        dryRun = false
)

public class Runner {
}

package cukesRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        plugin = {"html:target/cucumber-html-report",
//                "json:target/cucumber.json",// generate report
//                "junit:target/cucumber.xml",
//                "rerun:target/rerun.txt"},
        features = "src/test/resources/webOrderTest",
        glue = "stepDefinition",
        tags = "@TEC-2001",
        dryRun = false
)

public class Runner {
}

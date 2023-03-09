package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
        features = "/Users/samueldianpermanaputra/IdeaProjects/SeleniumCucumberBDD/Features",
        glue = "stepDefinitions",
        dryRun = true,
        monochrome = true,
        plugin = {"pretty",
                "html: test-output",
                "json:target/cucumber.json"}

        )


public class TestRunner {
}

package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/main/java/Features",          // path to feature files
        glue = {"StepDefinitions"},    // package containing step defs
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/Cucumber.json",
                "timeline:target/test-output-thread/"
        },
        monochrome = true,
        dryRun = false,
        tags= "@Sort"
)
public class LoginTestRunner {

}

package StepDefinitions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:/Users/jmenioui/PatientLink-Automation-Test/Features",glue = {"StepDefinitions"},
        monochrome = true,
        plugin = {"pretty",
                "json:target/cucumber.json"},

        dryRun = false
)

public class Runner {
}

package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@shopping",
        features = {"src/test/resources/Features"},
        glue = {"StepDefinitions"},
        plugin = {"pretty",
                "html:target/Cucumber-JVM-Reports/cucumber-reports/html-report",
                "junit:target/Cucumber-JVM-Reports/cucumber-reports/cucumber.xml",
                "json:target/json-report/cucumber.json",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        dryRun = false
)
public class RunCucumberTest {
}
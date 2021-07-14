package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/features", glue={"com.jan.stepdef.ecosia", "com.jan.stepdef.pathe"},
        plugin={"pretty", "html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberJson.json"},
monochrome = true)
public class TestRunner {
}

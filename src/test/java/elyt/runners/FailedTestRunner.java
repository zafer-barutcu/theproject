package elyt.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"html:target/failed-html-report"},
        glue = "elyt/step_definitions",
        features = "src/test/resources/features"
)
public class FailedTestRunner {
}

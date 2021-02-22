package RunnerKayak;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "resources/FeatureFiles",
        glue={"src/test/java/com/kayak/StepDefintions"},
        plugin = {"pretty","html:target/Reports"})
public class RunnerTest{

}
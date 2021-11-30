package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/FeatureFiles/getQuote.feature",
        glue = {"stepDefinition"}

)
public class CoverGeniusTestRunner extends AbstractTestNGCucumberTests {

}

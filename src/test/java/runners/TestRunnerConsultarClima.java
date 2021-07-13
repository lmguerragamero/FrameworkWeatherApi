package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/api/ConsultarClima.feature",
        glue = {"co/com/sofka/weather/test/steps/api"}
)
public class TestRunnerConsultarClima {
}

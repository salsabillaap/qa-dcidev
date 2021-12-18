import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
    plugin = {"pretty"},
        features = "src/test/resources/features/signup",
        tags = "@TC_6"
)
public class TestSuite {
}

// update tes
// uodate tes 2
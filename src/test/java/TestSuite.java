import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberSerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberSerenityRunner.class)
@CucumberOptions(
    plugin = {"pretty"},
        features = "src/test/resources/features/groupproduct",
        tags = "@TC_2"
)
public class TestSuite {
}

// update tes
// uodate tes 2
// update test 3
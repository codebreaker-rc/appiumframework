package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import netscape.javascript.JSObject;
import org.example.core.DriverManager;
import org.example.core.FwkVariables;
import org.example.core.JsonReader;
import org.json.JSONObject;
import org.testng.annotations.*;

@CucumberOptions(
        plugin = {"pretty" ,"html:target/cucumber-reports/cucumber.html"},
        features = {"src/test/resources"},
        glue = "stepdefs",
        tags = "@test"
)
public class TestNGRunnerTest {

    private TestNGCucumberRunner testNGCucumberRunner;

    @Parameters("deviceName")
    @BeforeClass(alwaysRun = true)
    public void setupClass(String deviceName) throws Exception {
        FwkVariables fwkVariables = new FwkVariables();
        fwkVariables.initFwkVariable(deviceName);
        DriverManager.initDriver(deviceName);
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(groups = "cucumber",description = "Runs cucumber scenarios", dataProvider = "scenarios")
    public void scenario(PickleWrapper pickle, FeatureWrapper cucumberFeature) throws Throwable{
        testNGCucumberRunner.runScenario(pickle.getPickle());
    }

    @DataProvider
    public Object[] scenarios(){
        return testNGCucumberRunner.provideScenarios();

    }

    @AfterClass
    public void tearDown(){
        if(DriverManager.getDriver() != null){
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }
        if(testNGCucumberRunner != null){
            testNGCucumberRunner.finish();
        }
    }

}

package StepDefinitions.Hooks;

import Utilities.ConfigurationReader;
import Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import static Utilities.FrameworkUtils.deleteOldLogs;
import static Utilities.Log.*;

/* example for cucumber hooks (not junit)   */

public class Hooks {
    private WebDriver driver = Driver.getDriver();
    private static boolean setUpIsDone = false;

    @BeforeClass
    public static void setUpClass() {
        //executed only once, before the first test
        deleteOldLogs(true);
    }


    @Before("not @hookless")
    // @Before will execute before every scenario unless its not tagged as @hookless
    public void setup(Scenario scenario) {
        startLog();
        if (setUpIsDone) {
            return;
        } else {
            info("===============================================================");
            info("|          Environment : " + ConfigurationReader.getProperty("env"));
            info("|          Operating System : " + System.getProperty("os.name"));
            info("|          Browser: " + ConfigurationReader.getProperty("browser"));
//            info("|          URL: " + ConfigurationReader.getProperty("url"));
            info("|          Author: " + ConfigurationReader.getProperty("author"));
            info("===============================================================\n");
            setUpIsDone = true;
        }

        info("===============================================================");
        info("|          Executed Tags: " + scenario.getSourceTagNames());
        info("|          Scenario Name: " + scenario.getName());
        info("===============================================================\n");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // driver.get(String.valueOf(ConfigurationReader.getProperty("url" + ConfigurationReader.getProperty("environment"))));

    }

    // @Before("not @hookless")            // or   @Before(order=2, value="@someTag")
    public void beforeScenario(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    @After("not @hookless")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        debug("Driver has been closed.");
    }

    @AfterClass
    public void tearDown() {
        endLog();
    }

}

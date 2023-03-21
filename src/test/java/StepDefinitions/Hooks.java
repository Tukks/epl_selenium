package StepDefinitions;

import io.cucumber.java.Before;
import managers.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

    public class Hooks {
        public static WebDriver driver;

        @Before
        public void setup() {
            driver= DriverManager.getdriver();

        }
        @After
        public void teardown(Scenario scenario) {
            if (scenario.isFailed()) {
                // Capture d'écran en cas d'échec du scénario
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "Capture d'écran"); // Ajout de la capture d'écran au rapport Cucumber
            }
            //driver.close();
        }



}

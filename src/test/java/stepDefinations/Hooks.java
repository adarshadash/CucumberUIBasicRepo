package stepDefinations;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;
import com.cucumber.listener.Reporter;
import Cucumber.Automation.Base;
import cucumber.api.java.Before;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks extends Base {

	@Before
	public void beforeValdiation() {
		System.out.println("Testing Started");
	}

	@After(order = 1)
	public void tearDown(Scenario Scenario) throws IOException {
		if (Scenario.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				
				FileHandler.copy(src,
						new File("/Users/abu/Documents/IMP framework/WebsiteCucumberJunit/target/cucumber-reports/Screenshot/"+ Scenario.getName() + ".png"));
						
				System.out.println(Scenario.getName());
				Scenario.embed(screenshot, "image/png");
				Reporter.addScreenCaptureFromPath("./Screenshot/"+ Scenario.getName() + ".png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
		
	}

	@After(order = 0)
	public void afterValdiation() {
		System.out.println("Testing Ended");
		driver.quit();

	}
}

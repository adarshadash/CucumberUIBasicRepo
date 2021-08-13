package cucumberOptions;

import java.io.File;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

//import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features/Login.feature", 
		glue = "stepDefinations", 
		tags = "@RegressionTest", 
		strict = true, monochrome = true,
				
plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/cukes.xml",
		"com.cucumber.listener.ExtentCucumberFormatter:/Users/abu/Documents/IMP framework/WebsiteCucumberJunit/target/cucumber-reports/report.html" })

public class TestRunner {
//public class TestRunner extends AbstractTestNGCucumberTests{
	//Converting Cucumber > TestNG > Maven

	//1. Create testing.xml file and add the testrunner as a class
	//2. Download cucumber testing dependencies
	//3. Modify the testRummer file
	//4. Modify the POM the XNL and provide the name of the testing.xnl file

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File("src/main/java/extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "macOS" + "Version-10.15.7");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");

		
	}

}

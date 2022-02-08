package TestRunner;


import org.testng.annotations.AfterClass;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	//@RunWith(Cucumber.class)
	@CucumberOptions(
	features = "C:\\Users\\sakthir\\git\\HybridCucumber\\HybridCucumber\\src\\test\\resources\\Feature\\TestCase.feature",
	plugin = {"pretty", //"html:reports/cucumberreport","json:reports/cucumberreport/jsonreport",
	//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	},
	glue="StepDefinition",
	strict=true
	)
	public class Testrunner extends AbstractTestNGCucumberTests{
@AfterClass
public void Extentsreport()
{
	Reporter.loadXMLConfig("C:\\Users\\sakthir\\git\\HybridCucumber\\HybridCucumber\\src\\test\\resources\\extent-config.xml");
	Reporter.setSystemInfo("user", System.getProperty("user.name"));
	Reporter.setSystemInfo("os", "Windows");
	Reporter.setTestRunnerOutput("Sample test runner output message"); }
}


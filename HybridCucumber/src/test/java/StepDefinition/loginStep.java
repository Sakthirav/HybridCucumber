package StepDefinition;

import java.io.IOException;

import BaseClass.LidraryClass;
import Pages.LogininPage;
import SeleniumResuableFunction.Seleniumutility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class loginStep extends LidraryClass {
	Seleniumutility S;
	LogininPage Lp;
	@Given("To launch the application and navigate to url")
	public void to_launch_the_application_and_navigate_to_url() {
		browserSetUp(); 
		logger.info("*******Browser Launch*********");
	}
	@When("Enter {string} and {string}")
	public void enter_and(String username, String password) {
		Lp=new LogininPage(driver);
		Lp.login(username,password);
			logger.info("*******Enter username and password*********");
	}
	@Then("To click the submit button")
	public void to_click_the_submit_button() {
		Lp.submit();
		logger.info("*******Click submit button*********");
	}
    @Then("To close the browser and take screenshot")
	public void to_close_the_browser_and_take_screenshot()  throws IOException {
		S=new Seleniumutility(driver);
		S.screenshot("C:\\Users\\sakthir\\git\\HybridCucumber\\HybridCucumber\\src\\test\\resources\\Screenshortslogin.png");
		logger.info("*******Taking Screenshot*********");
		 tearDown();
			}
}

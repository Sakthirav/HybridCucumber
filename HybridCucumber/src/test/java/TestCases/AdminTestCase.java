package TestCases;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.LidraryClass;
import Pages.Adminpage;
import Pages.LogininPage;
import SeleniumResuableFunction.Seleniumutility;
public class AdminTestCase extends LidraryClass{
	Seleniumutility selenium;
	Adminpage Ap;
	LogininPage lp;
	@BeforeMethod
	public void openapp()
	{
		browserSetUp() ;
		//launchapp("chrome","https://opensource-demo.orangehrmlive.com/");
	}
	@Test(priority=1)
	public void login()
	{
	lp=new LogininPage(driver);
	lp.login("Admin","admin123");
	}

	@Test(priority=2)
	public void Admin()
	{
	Ap=new Adminpage(driver);
	Ap.Admin("Admin", "ArslanMomin");
	}

	@AfterMethod
	public void teardown() throws IOException
	{
	selenium=new Seleniumutility(driver);
	selenium.screenshot("C:\\Users\\HP\\git\\Hybrid-Cucumber\\HybridCucmber\\src\\test\\resources\\Screenshots\\Admin.png");
	//closeapp();
	}
}

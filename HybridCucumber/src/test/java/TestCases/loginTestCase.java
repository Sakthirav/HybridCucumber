package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.LidraryClass;
import Pages.LogininPage;
import SeleniumResuableFunction.Seleniumutility;

public class loginTestCase extends LidraryClass{
Seleniumutility selenium;
	LogininPage lp;
	@BeforeMethod
	public void openapp()
	{
		browserSetUp();
		//("chrome","https://opensource-demo.orangehrmlive.com/");
	}
	@Test
	public void login()
	{
		 lp=new LogininPage(driver);
		lp.login("Admin","admin123");
		lp.submit();
	}
	
	@AfterMethod
	public void teardown() throws IOException
	{
	 selenium=new Seleniumutility(driver);
	 selenium.screenshot("C:\\Users\\sakthir\\git\\HybridCucumber\\HybridCucumber\\src\\test\\resources\\Screenshortslogin.png");
	 //closeapp();
	}
	public void close() {
		tearDown();
	}
}

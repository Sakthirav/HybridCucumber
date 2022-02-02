package SeleniumResuableFunction;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import BaseClass.LidraryClass;

public class Seleniumutility extends LidraryClass {
	public Seleniumutility(WebDriver driver)
	{
		this.driver=driver;
	}
	public void screenshot(String path) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File(path));
	}
	public void gettitle()
	{
		System.out.println(driver.getTitle());
	}
	public void dropdown(String value,String locator)
	{
		Select sel=new Select(driver.findElement(By.id(locator)));
		sel.selectByValue(value);
		
	}

}

package BaseClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LidraryClass {
	protected WebDriver driver;
	public void launchapp(String browser,String url)
	{
	try {

		if(browser.equalsIgnoreCase("firebox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(url);
	}
	catch(WebDriverException e)
	{
		System.out.println("browser couldnot be launched");
	}
	}

	public void closeapp()
	{
		driver.close();
	}

	}


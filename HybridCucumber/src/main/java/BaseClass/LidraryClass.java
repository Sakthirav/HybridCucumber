package BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LidraryClass {
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;


	public static void browserSetUp() {
	properties = new Properties();
	try {
	FileInputStream inputStream = new FileInputStream("C:\\Users\\sakthir\\git\\HybridCucumber\\HybridCucumber\\src\\test\\resources\\Configuration.Property\\cofig.property");
	try {
	properties.load(inputStream);
	} catch (IOException e) {
	e.printStackTrace();
	}
	} catch (FileNotFoundException e) {
	e.printStackTrace();
	}

	logger = Logger.getLogger(LidraryClass.class);
	PropertyConfigurator.configure("C:\\Users\\sakthir\\git\\HybridCucumber\\HybridCucumber\\src\\test\\resources\\log4j.property\\log4j.property");
	logger.info("*******Starting with Browser Set Up*********");
	String browser = properties.getProperty("browser");
	String url = properties.getProperty("url");
	System.out.println("url::::::"+url);


	switch (browser.toLowerCase()) {

	case "chrome":
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	break;
	case "firefox":
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
	logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
	break;

	case "ie":
	WebDriverManager.iedriver().setup();
	driver = new InternetExplorerDriver();
	logger.info(String.format("Identified the browser as %s. Launching the browser", browser));
	break;
	case "headlessbrowser":
	WebDriverManager.chromedriver().setup();
	ChromeOptions options=new ChromeOptions();
	options.setHeadless(true);
	WebDriver driver=new ChromeDriver(options);

	default:
	logger.info(String.format("Could not identify the browser as %s. Please specify correct browser", browser));
	break;
	}
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	logger.info("Launched the cucumber Application");
	}

	public static void tearDown() {
	driver.quit();
	logger.info("Exiting the application and closing the browser");
	}

	}
	


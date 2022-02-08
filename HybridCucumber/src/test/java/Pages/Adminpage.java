package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import BaseClass.LidraryClass;
public class Adminpage{
	WebDriver driver;
	@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']")
	WebElement admin;
	@FindBy(id="//*[@id='menu_admin_UserManagement']")
	WebElement usermanagement;
	@FindBy(id="//*[@id='menu_admin_viewSystemUsers']")
	WebElement systemuser;
	@FindBy(id="//input[@name='searchSystemUser[userName]']")
	WebElement username;
	@FindBy(id="//*[@id='searchSystemUser_employeeName_empName']")
	WebElement empname;
	@FindBy(id="//*[@id='searchBtn']")
	WebElement search;
	public Adminpage(WebDriver driver)
	{
	this.driver=driver;
	PageFactory.initElements(driver ,this);
	}
	public void Admin(String Admin,String ArslanMomin)
	{
	username.sendKeys(Admin);
	empname.sendKeys(ArslanMomin);
	Select user=new Select(driver.findElement(By.xpath("//*[@id='searchSystemUser_userType']")));
	user.selectByIndex(2);
	Select status=new Select(driver.findElement(By.xpath("//*[@id='searchSystemUser_status']")));
	status.selectByIndex(1);
	}

	public void submit() {
	admin.click();
	usermanagement.click();
	systemuser.click();
	search.click();
	}
}
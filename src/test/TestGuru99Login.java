package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Guru99HomePage;
import pages.Guru99Login;

public class TestGuru99Login {

	WebDriver driver;
	
	Guru99Login objLogin;
	
	Guru99HomePage objHomePage;
	
	@BeforeTest
	
	public void setup()
	{
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/v4/");
	}
	
	@Test(priority=0)
	
	public void test_Home_Page_Appear_Correct()
	{
		objLogin = new Guru99Login(driver);
		
		String loginPageTitle = objLogin.getLoginTitle();
		
		Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
		
		objLogin.loginToGuru99("mgr123","mgr!23");
		
		objHomePage = new Guru99HomePage(driver);
		
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}
}

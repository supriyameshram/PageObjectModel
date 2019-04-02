package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.Guru99HomePage;
import pageFactory.Guru99Login;

public class Test99GuruLoginWithPageFactory {
	
	WebDriver driver;
	
	Guru99Login objLogin;
	
	Guru99HomePage objHomePage;
	
	@BeforeTest
	
	public void setUp()
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
		
		objLogin.loginToGuru99("mgr123", "mgr!23");
		
		objHomePage = new Guru99HomePage(driver);
		
		Assert.assertTrue(objHomePage.getHomePAgeDashboardUserName().toLowerCase().contains("manger id : mgr123"));
	}

}

package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Guru99Login {

	WebDriver driver;
	
	@FindBy(name="uid")
	
	WebElement guru99username;
	
	@FindBy(name="password")
	
	WebElement guru99password;
	
	@FindBy(className="barone")
	
	WebElement titleText;
	
	@FindBy(name="btnLogin")
	
	WebElement login;
	
	public Guru99Login(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String strUserName)
	{
		guru99username.sendKeys(strUserName);
	}
	
	public void setPassword(String strPassword)
	{
		guru99password.sendKeys(strPassword);
	}
	
	public void clickLogin()
	{
		login.click();
	}
	
	public String getLoginTitle()
	{
		return titleText.getText();
	}
	
	public void loginToGuru99(String strUserName, String strPassword)
	{
		this.setUserName(strUserName);
		
		this.setPassword(strPassword);
		
		this.clickLogin();
	}
}

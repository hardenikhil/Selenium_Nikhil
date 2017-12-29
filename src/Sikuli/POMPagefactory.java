package Sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class POMPagefactory 
{
	
	WebDriver driver;
	
	@FindBy(id="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement password;
	
	public void POMPagefactory(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	public void main(String uname, String upwd)
	{
		username.sendKeys(uname);
		
	}
	
	
}

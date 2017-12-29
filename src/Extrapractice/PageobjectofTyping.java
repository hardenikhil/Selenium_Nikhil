package Extrapractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageobjectofTyping 
{
	
	WebDriver driver;
	
	By username=By.xpath("//input[@id='username']");
    By password=By.xpath("//input[@tabindex='2']");
	By loginbutton=By.xpath("//a[@class='button submit']");
	By toolusername=By.id("log");
	By toolpassword=By.id("pwd");
	By toollogin=By.xpath("//input [@id='login']");
	
	public PageobjectofTyping(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	public void typeusername(String userid)
	{
		driver.findElement(username).sendKeys(userid);
	}
	
	public void typeuserpassword(String userpwd)
	{
		driver.findElement(password).sendKeys(userpwd);
	}
	
	public void login()
	{
		driver.findElement(loginbutton).click();
	}
	
	
	public void typinglogin(String uid, String upwd) throws Exception
	{
		driver.findElement(toolusername).sendKeys(uid);
		driver.findElement(toolpassword).sendKeys(upwd);
		driver.findElement(toollogin).click();
		Thread.sleep(2000);
	}

}

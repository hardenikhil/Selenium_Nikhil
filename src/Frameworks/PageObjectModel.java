package Frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageObjectModel 
{
	
WebDriver driver;

By username=By.xpath("//input[@id='username']");
By password=By.xpath("//input[@name='password']");
By click=By.xpath("//a[@class='button submit']");

public PageObjectModel(WebDriver driver1)
{
	this.driver=driver1;
}
	
public void typeuser(String uid)
{
	driver.findElement(username).sendKeys(uid);
}

public void typepass(String upass)
{
	driver.findElement(password).sendKeys(upass);
}

public void clicklogin()
{
	driver.findElement(click).click();
}


}

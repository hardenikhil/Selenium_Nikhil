package Frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Crossbrowser 
{
	@Parameters("Browser")
	@Test
	public void test1(String Browser) throws InterruptedException
	{
		if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikhil\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://www.typing.com/teacher");
			Thread.sleep(2000);
			driver.quit();
		}
		else if(Browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Users\\nikhil\\IEDriverServer.exe");
			WebDriver driver=new InternetExplorerDriver();
			driver.navigate().to("https://www.typing.com/teacher");
			Thread.sleep(2000);
			driver.quit();
			
			
		}
		
	}
	
	
}

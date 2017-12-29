package practicedemo;

import org.testng.annotations.Test;
import newpackage.WebElements;
import org.testng.annotations.BeforeTest;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Highlight {
			
			public WebDriver driver;
			String url="http://192.168.0.20/";
			String p="C:\\Users\\nikhil\\chromedriver.exe";
			String b="webdriver.driver.chromedirver";

@Test
  public void f() throws InterruptedException 
  {
		driver.findElement(By.id("txtuname")).sendKeys("sanjeev_dubey");
		driver.findElement(By.id("txtPwd")).sendKeys("giis123");
		Select dropdown=new Select(driver.findElement(By.id("cmbBranch")));
		dropdown.selectByValue("Queenstown");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.xpath(".//*[@id='dd0']/div[29]/a[2]")).click();
		driver.findElement(By.id("sd165")).click();
		driver.switchTo().frame(0);		
		Thread.sleep(1000);
		WebElement calender1=driver.findElement(By.xpath(".//*[@id='anchorA']/img"));
		calender1.click();
		driver.switchTo().defaultContent();
		
		String parentwindow=driver.getWindowHandle();
		Set<String>childwindow=driver.getWindowHandles();
		for(String handle:childwindow)
		{
			driver.switchTo().window(handle);
			driver.manage().window().maximize();
			
		}
		List<WebElement>alldates=driver.findElements(By.xpath("html/body/center/table[2]/tbody/tr[8]/td/a"));
		for (WebElement elements:alldates)
		{
			String date=elements.getText();	
			if(date.equalsIgnoreCase("20"))
			{
					elements.click();
					break;
			}
			
		 }
		
		
	}

  @BeforeTest
  public void beforeTest() 
  {
	  System.getProperty("b", "p");
	  driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(url);  
  }


  @AfterTest
  public void afterTest() 
  {
	  
  
  }

}

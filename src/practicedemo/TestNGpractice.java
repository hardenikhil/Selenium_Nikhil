package practicedemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class TestNGpractice {
	String url="http://toolsqa.com/";
	String b="webdriver.chrome.driver";
	String p="C:\\Users\\nikhil\\chromedriver.exe";
	public WebDriver driver;
	
  @Test
  public void f() throws InterruptedException {
	
	  Actions action=new Actions(driver);
	  WebElement demosite=driver.findElement(By.xpath(".//*[@id='primary-menu']/li[8]/a/span[1]/span/span"));
	  action.moveToElement(demosite).build().perform();
	  Thread.sleep(1000);
	  action.click(demosite).build().perform();
	  
	  Actions action1=new Actions(driver);
	  WebElement ecomm=driver.findElement(By.xpath(".//*[@id='primary-menu']/li[8]/ul/li[1]/a/span[1]/span/span"));
	  action.moveToElement(ecomm).build().perform();
	  Thread.sleep(1000);
	  action.click(ecomm).build().perform();
	  
	  String parentwindow=driver.getWindowHandle();
	  Set<String> childwindow=driver.getWindowHandles();
	  for(String handle:childwindow)
	  {
		driver.switchTo().window(handle);
		  
	  }
	    
	 }
	 
  
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("b", "p");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
	  driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);  
  }
  
  @AfterTest
  public void afterTest() {
  }

}

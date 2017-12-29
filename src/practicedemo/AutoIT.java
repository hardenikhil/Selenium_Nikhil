package practicedemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class AutoIT {
	String b="webdriver.chrome.driver";
	String p="C:\\Users\\nikhil\\chromedriver.exe";
	String url="https://uploadfiles.io/";
	public WebDriver driver;
		
	@Test
  public void f() throws Exception 
  {
	  driver.findElement(By.xpath("//form[@id='upload-window']")).click();
	  Runtime.getRuntime().exec("C:\\selenium\\upload1.exe");
	  
  }
  
  @BeforeTest
  public void beforeTest() 
  {
	  System.setProperty("b","p");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);  
  }
 
  @AfterTest
  public void afterTest()
  {
	  
  }

}

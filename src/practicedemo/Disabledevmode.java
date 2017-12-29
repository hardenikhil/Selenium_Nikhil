package practicedemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

public class Disabledevmode {
		public WebDriver driver;
		String url= "http://www.globalsqa.com/";
		String b="webdriver.chrome.driver";
		String p="C:\\Users\\nikhil\\chromedriver.exe";
	
  @Test
  public void f() {
	 
	  driver.findElement(By.xpath(".//*[@id='menu-item-1513']/a")).click();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("b", "p");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(url);
	  ChromeOptions options=new ChromeOptions();
	  options.addArguments("--disable-extensions");
	  WebDriver driver=new ChromeDriver(options);
  }

  @AfterTest
  public void afterTest() {
  
	  driver.quit();
  
  }

}

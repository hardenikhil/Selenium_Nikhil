package practicedemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TestNG {
	
	String b="webdriver.driver.chromedriver";
	String p="C:\\Users\\nikhil\\chromedriver.exe";
	
	public WebDriver driver;
	
  @Test
  public void main() {
	  driver.findElement(By.id("account")).click();
	  driver.findElement(By.xpath(".//*[@id='log']")).sendKeys("nik3123");
	  driver.findElement(By.xpath(".//*[@id='pwd']")).sendKeys("giis123");
	  driver.findElement(By.xpath(".//*[@id='login']")).click();
	  System.out.println(" Login Successfully, now it is the time to Log Off buddy.");
	  driver.findElement(By.id("account_logout")).click();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("b","p");
	  driver=new ChromeDriver ();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://store.demoqa.com/");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  	driver.quit();
  
  }

}

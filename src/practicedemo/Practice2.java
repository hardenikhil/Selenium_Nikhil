package practicedemo;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practice2 {

	public class AutoIT {
		String b="webdriver.chrome.driver";
		String p="C:\\Users\\nikhil\\chromedriver.exe";
		String url="http://jqueryui.com";
		public WebDriver driver;
			
		@Test
	  public void f() throws Exception 
	  {
			
		JavascriptExecutor jr=(JavascriptExecutor)driver;
		
		WebElement text=driver.findElement(By.xpath("//a[text()='Show']"));
		
		jr.executeScript("arguments[0].scrollIntoView(true);",text);
		
		System.out.println(text.getText());
		
		//jr.executeScript("Scroll(0,600)");
		
		//((JavascriptExecutor)driver).executeScript("scroll(0,400)");		  
				     
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
}

package newpackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MultipleWindows {

	public static void main(String [] args){
		
		String url= "http://demoqa.com/";
		String browser= "webdriver.chrome.driver";
		String d="C:\\Users\\nikhil\\chromedriver.exe";
		
		System.getProperty("b", "p");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebElement frame=driver.findElement(By.xpath("//a[text()='Frames and windows']"));
		frame.click();
		WebElement frame1=driver.findElement(By.xpath("//a[text()='New Browser Tab']"));
		frame1.click();
		
		
				
		String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		for(String window:childwindow)
		{
			driver.switchTo().window(window);
			
		}
		driver.get("http://www.google.com");
		driver.get("http://www.toolsqa.com");
		driver.close();
		driver.switchTo().window(parentwindow);
		driver.get("http://www.quora.com");
	
	   }
	}




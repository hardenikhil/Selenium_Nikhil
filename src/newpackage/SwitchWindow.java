package newpackage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindow {
	
	public static void main(String[] args){
		
		String url ="http://toolsqa.com/automation-practice-switch-windows/";
		String browser= "webdriver.chrome.driver";
		String path= "C:\\Users\\nikhil\\chromedriver.exe";
		
		System.getProperty("browser", "path");
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get(url);
		
		String handle= driver.getWindowHandle();
		
		driver.findElement(By.id("button1")).click();
		
		Set handles = driver.getWindowHandles();
		
		for (String handle1 : driver.getWindowHandles()) {
			 
				driver.switchTo().window(handle1);
		   	}
		
	}

}

package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Newnavigation {
	
	static public void main(String[] arg){
		 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikhil\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demoqa.com");
		
		driver.findElement(By.linkText("Registration")).click();
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().to("http://demoqa.com");
		
		driver.navigate().refresh();
		
		driver.close();

	}
}
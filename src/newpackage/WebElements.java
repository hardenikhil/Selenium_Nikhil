package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
	
	public static void main(String[] agrs){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nikhil\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://store.demoqa.com/products-page/your-account/");	
		
		WebElement username = driver.findElement(By.id("log"));
		username.sendKeys("nik3123");
		
		WebElement password = driver.findElement(By.id("pwd"));
		password.sendKeys("giis123");
		
		driver.findElement(By.id("login")).click();
		
		//xpath("//input[@value='Submit »]"
		
		
	}

}

package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElement {

	public static void main(String[] args){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikhil\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://toolsqa.com/automation-practice-form/");
		
		driver.findElement(By.name("firstname")).sendKeys("Nikhil");
		
		driver.findElement(By.name("lastname")).sendKeys("Harde");
		
		WebElement radio1 = driver.findElement(By.id("sex-0"));
		radio1.click();
		
		WebElement radio2 = driver.findElement(By.id("exp-0"));
		radio2.click();
		
		driver.findElement(By.id("datepicker")).sendKeys("3march2017");
		
		WebElement radio3 = driver.findElement(By.id("profession-1"));
		radio3.click();
	
		
				
	}
}

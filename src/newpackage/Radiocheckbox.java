package newpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Radiocheckbox {
	
	public static void main(String[] args) throws InterruptedException, IOException{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikhil\\chromedriver.exe");
	
	WebDriver driver= new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	driver.get("http://toolsqa.com/automation-practice-form/");
	
	driver.findElement(By.name("firstname")).sendKeys("Nikhil");
	
	Thread.sleep(2000);
	
	driver.findElement(By.name("lastname")).sendKeys("Harde");
	
	Thread.sleep(2000);
	
	WebElement radio1= driver.findElement(By.id("sex-0"));
	radio1.click();
	
	Thread.sleep(2000);
	
	WebElement radio2= driver.findElement(By.id("exp-2"));
	radio2.click();
	
	Thread.sleep(2000);
	
	driver.findElement(By.id("datepicker")).sendKeys("2017-03-20");
	
	WebElement checkbox= driver.findElement(By.id("profession-0"));
	checkbox.click();
	
	Thread.sleep(2000);
	
	WebElement photo= driver.findElement(By.id("photo"));
	photo.sendKeys("C:\\Users\\nikhil\\Downloads\\New folder");
	//AutoIT
	//Runtime.getRuntime().exec("C:\\Users\\nikhil\\Downloads\\autoit.exe");
	
	WebElement tool=driver.findElement(By.id("tool-2"));
	tool.click();
	
	Thread.sleep(2000);
	
	Select oSelect = new Select(driver.findElement(By.id("continents")));
	oSelect.selectByIndex(4);
	
	Select oSelect1= new Select(driver.findElement(By.id("selenium_commands")));
	oSelect1.selectByVisibleText("Browser Commands");
	oSelect1.selectByVisibleText("Navigation Commands");
	
	WebElement submit= driver.findElement(By.id("submit"));
	submit.click();
	
	driver.quit();
	
	//xpath("//input[@value='Submit »]"
	
	

}
	
}

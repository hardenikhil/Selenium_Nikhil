package newpackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Mycalender {
	
	public static void main(String[] args){
			
		String url= "https://enterprise-demo.orangehrmlive.com/auth/login";
		String b="webdriver.chrome.driver";
		String p="C:\\Users\\nikhil\\chromedriver.exe";
		
		
		System.getProperty("b", "p");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		driver.findElement(By.id("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin");
		driver.findElement(By.id("btnLogin")).click();
		WebElement leave= driver.findElement(By.xpath(".//*[@id='menu_leave_viewLeaveModule']/b"));
		Actions action=new Actions(driver);
		action.moveToElement(leave).build().perform();
		leave.click();
		driver.findElement(By.xpath(".//*[@id='calFromDate']")).click();
		//month drop down select
		Select month=new Select(driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div/div/select[1]")));
		month.selectByVisibleText("May");
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		for(WebElement ele:allDates)
		{
			
			String date=ele.getText();
			
			if(date.equalsIgnoreCase("1"))
			{
				ele.click();
				break;
			}
		}	
	}
}
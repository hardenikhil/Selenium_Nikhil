package practicedemo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadrivenframework {

	@Test(dataProvider="testdata")
	public void toolsqadata(String username,String password) throws Exception
	{
		String browser= "webdriver.chrome.driver";
		String path= "C:\\Users\\nikhil\\chromedriver.exe";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.typing.com/student/login");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//a[@class='button submit']")).click();
		Thread.sleep(5000);
		//System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Lessons"));
		driver.quit();
	}
	
	@DataProvider(name="testdata")
	public Object[][] testdatafeed()
	{
		Object[][] toolsqa=new Object[3][2];
		
		toolsqa[0][0]="nik123";
		toolsqa[0][1]="giis";
		toolsqa[1][0]="nik3123";
		toolsqa[1][1]="demo123";
		toolsqa[2][0]="nik1234";
		toolsqa[2][1]="giis";
		
		return toolsqa;
	}
}

package Frameworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datadriven2 
{
@Test(dataProvider="testdata")	
public void loginpage(String username,String password) throws Exception
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
public Object[][] typingdata()
{
	ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\nikhil\\Desktop\\TestData.xlsx");
	
	int rows=config.getrowcount(0);
	
	Object[][] data=new Object[rows][2];
	
	for(int i=0;i<rows;i++)
	{
		data[i][0]=config.getdata(0, i, 0);
		data[i][1]=config.getdata(0, i, 1);
	}
	
	return typingdata();

}

}

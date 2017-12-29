package Frameworks;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import jxl.Cell;
import jxl.JXLException;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class JexcelDataDriven 
{
	
public WebDriver driver;
public WebDriver driver1;
	
@Test(dataProvider="testdata")
public void login(String username, String password) throws Exception
{
	String b="webdriver.driver.chromedriver";
	String p="c:\\users\\nikhil\\chromedriver.exe";
	String url="http://www.typing.com/student/login";
	System.getProperty("b","p");
	driver=new ChromeDriver();
	driver.navigate().to(url);
	
	//driver.get("http://www.typing.com/student/login");
	
	PageObjectModel loginpage=new PageObjectModel(driver1);
	loginpage.typeuser(username);
	loginpage.typepass(password);
	loginpage.clicklogin();
	Assert.assertEquals("https://www.typing.com/student", driver.getCurrentUrl());
	driver.close();
	/*driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
	driver.findElement(By.xpath("//a[@class='button submit']")).click();
	Thread.sleep(2000);
	Assert.assertEquals("https://www.typing.com/student", driver.getCurrentUrl());
	driver.close();*/

}
	
@DataProvider(name="testdata")
public Object[][] testdatafeed() throws BiffException, Exception 
{

//load excel sheet	
File src=new File("C:\\Users\\nikhil\\Desktop\\TestFile.xls");

//load workbook
Workbook wb=Workbook.getWorkbook(src);

//load sheet
Sheet sh1=wb.getSheet(0);
int rows=sh1.getRows();
int columns=sh1.getColumns();

String inputdata[][]=new String [rows][columns];
for (int i=0;i<rows;i++)
{
 for(int j=0;j<columns;j++)
 {
	 Cell c=sh1.getCell(j,i);
	 inputdata[i][j]=c.getContents();
 }

}
return inputdata;
	
}
	
	
}


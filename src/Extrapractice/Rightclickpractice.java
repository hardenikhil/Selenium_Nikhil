package Extrapractice;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hpsf.Property;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class Rightclickpractice 
{
	WebDriver driver;
	WebDriver driver1;
	
  @Test(dataProvider="testdata")
  public void test(String userid, String userpwd) throws Exception 
  {
	  //load property 
	  File src=new File("C://Users//nikhil//workspace//newproject//src//practicedemo//object_repo.properties");
	  FileInputStream fis=new FileInputStream(src);
	  Properties pro=new Properties();
	  pro.load(fis);
	  System.out.println("properties file loaded");
	  
	  //login in toolsqa
	  System.setProperty(pro.getProperty("browser"), pro.getProperty("path"));
	  WebDriver driver=new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get(pro.getProperty("url"));
	  driver.findElement(By.xpath("//a [@class='account_icon']")).click();
	  
	  //page object of toolsqa login
	  PageobjectofTyping tools=new PageobjectofTyping(driver);
	  tools.typinglogin("aka123", "giis123");
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//a[contains(.,'All Product')]")).click();
	  
	  //right click on category
	  Actions action2=new Actions(driver);
	  WebElement link=driver.findElement(By.xpath("//a[@href='http://store.demoqa.com/products-page/product-category/n/']"));
	  action2.contextClick(link).build().perform();
	  Robot robot = new Robot();
	  robot.keyPress(KeyEvent.VK_DOWN);
	  robot.keyPress(KeyEvent.VK_ENTER);
	  
	  //switch to other window
	  String parentwindow=driver.getWindowHandle();
	  Set <String> childwindow=driver.getWindowHandles();
	  for(String window:childwindow)
	  {
		  driver.switchTo().window(window);   
	  }	
	  driver.get("https://www.typing.com/student/login");
	  tools.typeusername(userid);
	  tools.typeuserpassword(userpwd);
	  tools.login();
	  //Assert.assertEquals("https://www.typing.com/student", driver.getCurrentUrl());
	  if (driver.getCurrentUrl().equals("https://www.typing.com/student"))
	  {
		  driver.findElement(By.xpath("//a[@class='active']")).click();  
	  }
	  else
	  {
		  driver.quit();
	  }
	  
	  
  }
  	  
  	  @DataProvider(name="testdata")
	  public Object[][] testdatafeed() throws BiffException, Exception
	  {

	  File src=new File("C://Users//nikhil//Desktop//TestFile.xls");
	  Workbook wb=Workbook.getWorkbook(src);
	  Sheet sh1=wb.getSheet(0);
	  int rows=sh1.getRows();
	  int columns=sh1.getColumns();
	  System.out.println("sheet loaded sucessfully");

	  String inputdata[][]=new String[rows][columns];
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


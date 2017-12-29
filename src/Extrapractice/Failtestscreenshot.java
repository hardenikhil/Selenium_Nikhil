package Extrapractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Failtestscreenshot 
{
	
 WebDriver driver;
	
  @Test
  public void maintest() throws Exception 
  {
	  	File src=new File("C://Users//nikhil//workspace//newproject//src//practicedemo//object_repo.properties");
	  	FileInputStream fis=new FileInputStream(src);
		Properties pro=new Properties();
		pro.load(fis);
		System.out.println("load successfully");
		
		System.setProperty(pro.getProperty("browser"), pro.getProperty("path"));
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(pro.getProperty("url"));
	  	driver.findElement(By.xpath("//input[@id='log434']")).sendKeys("dgdrtrdt");
	  	driver.findElement(By.xpath("//input[@id='pwd4343']")).sendKeys("dgdrtrdt");
	  	driver.findElement(By.xpath("//input[@id='login545']")).click();
  }


  @AfterMethod
  public void afterMethod(ITestResult result) 
  {
	  
	if(ITestResult.FAILURE==result.getStatus())
	{
	try
	{
		 TakesScreenshot ts=(TakesScreenshot)driver;
		 File source=ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(source, new File("./Screenshot/"+result.getName()+".png"));
	}
	catch(Exception e)
    {
		System.out.println("login successful");
    }
  }
  }
 }


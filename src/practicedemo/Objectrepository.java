package practicedemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Objectrepository 
{		
	String b="webdriver.driver.chromedriver";
	String p="C:\\Users\\nikhil\\chromedriver.exe";
	WebDriver driver;
	
	@Test
	public void beforeTest() throws Exception 
	{
		File src=new File("C:/Users/nikhil/workspace/newproject/src/practicedemo/object_repo.properties");
		
		FileInputStream fis=new FileInputStream(src);
		
		Properties pro=new Properties();
		
		pro.load(fis);
		System.out.println("file is loaded");
		
		System.setProperty("b", "p");
		driver=new ChromeDriver();
		driver.get("http://store.demoqa.com/products-page/your-account/");	
		driver.findElement(By.xpath(pro.getProperty("user.login.xpath"))).sendKeys("nik3123");
		driver.findElement(By.xpath(pro.getProperty("user.password.xpath"))).sendKeys("giis123");
		driver.findElement(By.xpath(pro.getProperty("login.xpath"))).click();
		Thread.sleep(5000);
		driver.close();
	}

}

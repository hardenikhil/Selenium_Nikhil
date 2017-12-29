package Extrapractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Alerttest 
{
	
	public static void main(String[] args) throws Exception 
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
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Simple Alert')]"))).click();
		//driver.findElement(By.xpath("//button[@onclick='pushConfirm()']")).click();
		Thread.sleep(2000);
		Alert alert= driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		driver.quit();
		
	}
}

package practicedemo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {

	public static void main(String[] args) throws Exception 
	{
		File src=new File("C:/Users/nikhil/workspace/newproject/src/practicedemo/object_repo.properties");
		
		FileInputStream fis=new FileInputStream(src);
		
		Properties pro=new Properties();
		
		pro.load(fis);
		System.out.println("file is loaded");
		
		String b="webdriver.driver.chromedriver";
		String p="C:\\Users\\nikhil\\chromedriver.exe";
		
		System.setProperty("b", "p");
		WebDriver driver=new ChromeDriver();
		driver.get("http://store.demoqa.com/products-page/your-account/");	
		driver.findElement(By.xpath(pro.getProperty("user.login.xpath"))).sendKeys("nik3123");
		driver.findElement(By.xpath(pro.getProperty("user.password.xpath"))).sendKeys("giis123");
		driver.findElement(By.xpath(pro.getProperty("login.xpath"))).click();
		Thread.sleep(5000);
		driver.close();
		
		

	}

}

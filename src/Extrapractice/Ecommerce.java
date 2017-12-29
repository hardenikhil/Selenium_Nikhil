package Extrapractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce 
{
	
	public static void main(String[] args) throws Exception 
	{
		File src=new File("C://Users//nikhil//workspace//newproject//src//practicedemo//object_repo.properties");
		FileInputStream fis=new FileInputStream(src);
		Properties pro=new Properties();
		pro.load(fis);
		System.out.println("properties loaded");
		
		System.setProperty(pro.getProperty("browser"),pro.getProperty("path"));
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		
		//login credentials
		driver.findElement(By.xpath("//a [@class='account_icon']")).click();
		driver.findElement(By.id("log")).sendKeys("aka123");
		driver.findElement(By.id("pwd")).sendKeys("giis123");
		driver.findElement(By.xpath("//input [@id='login']")).click();
		Thread.sleep(5000);
		
		//move mouse to category section
		WebElement category=driver.findElement(By.xpath("//li [@id='menu-item-33']"));
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.moveToElement(category).build().perform();
		Thread.sleep(2000);
		
		WebElement accessories=driver.findElement(By.xpath("//li [@id='menu-item-34']"));
		Actions action1=new Actions(driver);
		action.moveToElement(accessories).build().perform();
		action.click(accessories).build().perform();
		
		//click on add to cart
		WebElement cart=driver.findElement(By.xpath(".//*[@id='default_products_page_container']/div[3]/div[2]/form/div[2]/div[1]/span/input"));
		cart.click();
		
		//remove quantity
		driver.findElement(By.id("header_cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='quantity']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='quantity']")).sendKeys("2");
		driver.findElement(By.xpath("//a[@class='step2']")).click();
		
		//fill address details
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='wpsc_checkout_form_9']")));
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_9']")).clear();
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_9']")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_2']")).clear();
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_2']")).sendKeys("Nikhil");
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_3']")).clear();
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_3']")).sendKeys("Harde");
		driver.findElement(By.xpath(".//*[@id='wpsc_checkout_form_4']")).clear();
		driver.findElement(By.xpath(".//*[@id='wpsc_checkout_form_4']")).sendKeys("XYZ");
		driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_5']")).clear();
	 	driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_5']")).sendKeys("Nagpur");
	 	driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_6']")).clear();
	 	driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_6']")).sendKeys("Maharashtra");
	 	driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_15']")).clear();
	 	driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_15']")).sendKeys("Maharashtra");
	 	Select country=new Select(driver.findElement(By.xpath("//select[@id='wpsc_checkout_form_7']")));
	 	country.selectByIndex(3);
	 	driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_18']")).clear();
	 	driver.findElement(By.xpath("//input[@id='wpsc_checkout_form_18']")).sendKeys("5656656");
	 	driver.findElement(By.xpath("//input[@class='make_purchase wpsc_buy_button']")).click();
	 	
	}
	 


}

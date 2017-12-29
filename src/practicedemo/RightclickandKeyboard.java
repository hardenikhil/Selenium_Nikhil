package practicedemo;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightclickandKeyboard {
	
	public static void main (String[] args){
		
		//String url="https://www.google.co.in";
		String url="http://www.google.com";
		String b="webdriver.chrome.driver";
		String p="C:\\Users\\nikhil\\chromedriver.exe";
		
		System.getProperty("b","p");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Actions action=new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//input[@name='btnK']"))).perform();

		
	}


}

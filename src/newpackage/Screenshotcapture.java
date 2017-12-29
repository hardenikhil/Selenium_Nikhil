package newpackage;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshotcapture {
	public static void main (String args[]){
	String url="http://192.168.0.20";
	String b="webdriver.driver.chromedriver";
	String p="c:\\users\\nikhil\\chromedriver.exe";
	
	System.getProperty("b","p");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try{
		
		FileUtils.copyFile(src, new File("c:/selenium/error.png"));
		
	   }
	 catch(Exception e){}
	}
	
}

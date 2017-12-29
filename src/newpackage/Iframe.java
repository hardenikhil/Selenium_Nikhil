package newpackage;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {

	public static void main(String[] agrs){
		
		String url= "http://toolsqa.com/iframe-practice-page/";
		String b= "webdriver.chrome.driver";
		String d= "C:\\Users\\nikhil\\chromedriver.exe";
		
		System.getProperty("b", "d");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(url);
		
		// To calculate total numbers of frame
		//JavascriptExecutor exe = (JavascriptExecutor) driver;
		//Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		//List <WebElement> iframeElements= (List<WebElement>) driver.findElements(By.tagName("iframe"));
		//System.out.println("The total number of iframes are " + iframeElements.size());
		
		WebElement iFrameElement= driver.findElement(By.id("IF1"));
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.name("firstname")).sendKeys("Nikhil");
		
		driver.findElement(By.name("lastname")).sendKeys("Harde");
		
		driver.switchTo().defaultContent();
		
		driver.quit();
		
		
		
		
		
		
		
	}
}

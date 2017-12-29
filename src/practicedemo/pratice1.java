package practicedemo;
//multiple windows
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class pratice1 {

	public static void main(String[] args){
		
		String url="http://www.globalsqa.com/";
		String b="webdriver.chrome.driver";
		String p="C:\\Users\\nikhil\\chromedriver.exe";
		
		System.getProperty("b", "p");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.get(url);
		WebElement testhub=driver.findElement(By.xpath(".//*[@id='menu-item-2822']/a"));
		Actions action=new Actions (driver);
		action.moveToElement(testhub).build().perform();
		WebElement demotest=driver.findElement(By.xpath(".//*[@id='menu-item-2823']/a/span"));
		Actions action1=new Actions(driver);
		action1.moveToElement(demotest).build().perform();
		WebElement windows=driver.findElement(By.xpath(".//*[@id='menu-item-2999']/a/span"));
		windows.click();
		driver.findElement(By.xpath(".//*[@id='post-2632']/div[2]/div[1]/div/div[1]/a")).click();
		
		String parentwindow=driver.getWindowHandle();
		Set <String> childwindow=driver.getWindowHandles();
		
		for (String handle: childwindow)
		{
			driver.switchTo().window(handle);
			
		}
		driver.get("https://www.google.co.in/");
		
	}
	
}

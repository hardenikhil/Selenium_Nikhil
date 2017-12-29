package newpackage;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
//mouse over & drag & drop
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.james.mime4j.field.address.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;

public class Basicjava {
		
	public static void main(String args[]) throws InterruptedException
	{
		String url="http://www.google.com";
		String b="webdriver.driver.chromedriver";
		String p="c:\\users\\nikhil\\chromedriver.exe";
		
		System.setProperty("b", "p");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
		
		Select select= new Select(driver.findElement(By.id("email")));
		List<WebElement> drop_down=select.getOptions();
		for (int i=0; i<drop_down.size();i++)
		{
			String drop_down_Values=drop_down.get(i).getText();
		
		}
	 }

}
		
	

	
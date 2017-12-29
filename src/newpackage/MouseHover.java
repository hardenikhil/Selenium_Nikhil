package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	
	public static void main(String[] args){
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.store.demoqa.com");
		
		WebElement element = driver.findElement(By.linkText("Product Category"));
		 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
 
        driver.findElement(By.linkText("iPads")).click();
        //Actions action=new Actions(driver);
  	  	//WebElement login=driver.findElement(By.xpath(".//*[@id='ctl00_HyperLinkLogin']"));
  	  	//action.moveToElement(login).build().perform();
  	  	//Thread.sleep(1000);
  	  	//action.click(login).build().perform()
	
	
	}
	

}

package newpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class myclass {

	 public static void main(String[] args) throws Exception {
		 
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\nikhil\\chromedriver.exe");
		
		 // Create a new instance of the Firefox driver
		WebDriver driver = new ChromeDriver();
		
        //Launch the Online Store Website 
		driver.get("https://www.orangehrm.com/User_Survey_Registration");

		WebElement element = driver.findElement(By.xpath(".//*[@id='register-form']/div[1]/div[2]/div/input"));
		element.sendKeys("nikhil");
		
		WebElement dropdown=driver.findElement(By.id("mail"));
		dropdown.click();	
		List <WebElement> list=driver.findElements(By.id("dd"));
		for(WebElement ele:list)
		{
			if(ele.getAttribute("innerHTML").contains("JavaScript"))
			{
				ele.click();
				break;
			}
			
		}
		
		
		
		
		
    }
	 
}
//xpath("//input[@value='Submit »]"

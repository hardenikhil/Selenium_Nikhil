package practicedemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scrollpage {

	public static void main(String[] args) {
		
		String url="http://192.168.0.20";
		String b="webdriver.chrome.driver";
		String p="C:\\Users\\nikhil\\chromedriver.exe";
		
		System.getProperty("b", "p");
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		((JavascriptExecutor)driver).executeScript("Scroll(0,400)");
	}

}

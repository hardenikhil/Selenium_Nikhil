package Sikuli;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class sikulitest 
{
	public static void main(String[] args) throws FindFailed
	{
	Screen screen=new Screen();
	
	Pattern image=new Pattern("C://Users//nikhil//Desktop//email.jpg");
	Pattern image1=new Pattern("C://Users//nikhil//Desktop//password.jpg");
	Pattern image2=new Pattern("C://Users//nikhil//Desktop//login.jpg");
	
	String b="webdriver.driver.chromedriver";
	String p="c:\\users\\nikhil\\chromedriver.exe";
	
	System.getProperty("b", "p");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.typing.com/teacher/login");
	screen.type(image, "nik3123");
	screen.type(image1, "demo123");
	screen.click(image2);
	
	
	}

}

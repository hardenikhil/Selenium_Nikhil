package newpackage;
 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
 
public class DragDrop {
 
public static void main(String[] args) throws InterruptedException {
 
WebDriver driver = new ChromeDriver();
 String URL = "http://jqueryui.com/resources/demos/droppable/default.html";
 driver.get(URL);
driver.manage().window().maximize();
 
// It is always advisable to Maximize the window before performing DragNDrop action
 
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);;
Actions action = new Actions(driver);
WebElement source = driver.findElement(By.id("draggable"));
WebElement Target = driver.findElement(By.id("droppable"));
action.dragAndDrop(source,Target).build().perform();

//Actions action = new Actions(driver);
 //Action dragDrop = action.clickAndHold(From).moveToElement(To).release(To).build();
//dragDrop.perform()


}
 
}


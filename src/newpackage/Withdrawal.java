package newpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Withdrawal {

	WebDriver driver;
	String url = "http://192.168.0.20/queenstown";
	String url1= "jdbc:sqlserver://192.168.0.21;databaseName=myGIISQT";
	String browser = "webdriver.chrome.driver";
	String d = "chromedriver.exe";
	static int pId = 20280, sId = 20279;

	@BeforeTest
	public void openBrowser() {
		System.setProperty(browser, d);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
	}

	@Test(priority = 0,enabled=false)
	public void ApplyWithdrawal() throws ElementNotVisibleException {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String userName = "Nikhil";
			String password = "Linkinpark1813@";

			//String url1 = "jdbc:sqlserver://192.168.0.21;databaseName=myGIISQT";
			Connection con = DriverManager.getConnection(url1, userName, password);
			Statement s1 = con.createStatement();
			Statement s2 = con.createStatement();

			ResultSet parent = s1.executeQuery("SELECT * FROM ICSAllUsers Where UserId=" + pId);

			while (parent.next()) {

				String parentId = parent.getString(2);
				String parentPwd = parent.getString(3);

				driver.findElement(By.name("txtuname")).sendKeys(parentId);
				driver.findElement(By.name("txtPwd")).sendKeys(parentPwd);
				driver.findElement(By.id("btnLogin")).click();
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(
						ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordion']/h3[4]/a/img")));

				driver.findElement(By.xpath("//div[@id='accordion']/h3[4]/a/img")).isDisplayed();
				driver.findElement(By.xpath("//div[@id='accordion']/h3[4]/a/img")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='accordion4']/h4[11]/a")));
			}
			boolean flag = driver.findElement(By.xpath("//div[@id='accordion4']/h4[11]/a")).isDisplayed();
			System.out.println(flag);
			driver.findElement(By.xpath("//div[@id='accordion4']/h4[11]/a")).click();
			driver.findElement(By.xpath("//span[text()='Apply Withdrawal']")).click();
			Thread.sleep(5000);
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//frame[@id='iframe1']")));
			driver.switchTo().frame(0);
			ResultSet stud = s2.executeQuery("SELECT * FROM ICSAllUsers Where UserId=" + sId);
			while (stud.next()) {
				String studentName = stud.getString(5) + " " + stud.getString(6);
				Select student = new Select(driver.findElement(By.id("ddliststud")));
				student.selectByVisibleText(studentName);
			}
			//if (driver.findElements(By.id("ddliststud")).size() > 1) {
				driver.findElement(By.id("btngetdeatils")).click();
			//}
			driver.findElement(By.xpath("//input[@id='ImgLastAttDt']")).click();
			driver.findElement(By.id("CalLastAttDt_title")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("CalLastAttDt_month_0_2")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[contains(text(),'10')]")).click();
			Thread.sleep(2000);
			Select reason = new Select(driver.findElement(By.id("ddlReasonCatg")));
			reason.selectByVisibleText("Not Joining ***");
			driver.findElement(By.id("ChkIAgreeCancel")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("but_submit")).click();
			Alert alert = driver.switchTo().alert();
			WebDriverWait w = new WebDriverWait(driver, 2);
			try {
				w.until(ExpectedConditions.alertIsPresent());

				{
					alert.accept();
				}
			} catch (Exception e) {
				System.out.println("No Alert");
			}
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void firstLevel() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String userName = "Nikhil";
			String password = "Linkinpark1813@";

			//String url1 = "jdbc:sqlserver://192.168.0.21;databaseName=myGIISQT";
			Connection con = DriverManager.getConnection(url1, userName, password);
			Statement s1 = con.createStatement();

			ResultSet stud = s1.executeQuery("SELECT * FROM ICSAllUsers Where UserId=" + sId);

			driver.findElement(By.name("txtuname")).sendKeys("sheetaldasgupt");
			driver.findElement(By.name("txtPwd")).sendKeys("giis123");
			Select campus = new Select(driver.findElement(By.id("cmbBranch")));
			campus.selectByValue("Queenstown");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Admission And Enquiry']")).click();
			driver.findElement(By.xpath("//a[text()='View/Approve Withdrawal Appl.']")).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//a[@id='lnksearchtitle']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Chkstudent")).click();
			while (stud.next()) {
				String studentName = stud.getString(5) + " " + stud.getString(6);
				Select student = new Select(driver.findElement(By.id("ddlstudent")));
				Thread.sleep(1000);
				student.selectByVisibleText(studentName);
			}
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='gridstudlist']/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("But_accept_Appl")).click();
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",
					driver.findElement(By.id("ddlReasonCatg")));
			Thread.sleep(500);
			Select reason = new Select(driver.findElement(By.id("ddlReasonCatg")));
			reason.selectByVisibleText("Health Issues");
			Thread.sleep(2000);
			driver.findElement(By.id("txtRemark_ADD")).clear();
			driver.findElement(By.id("txtRemark_ADD")).sendKeys("Approved");
			driver.findElement(By.id("but_submit")).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void secondLevel() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String userName = "Nikhil";
			String password = "Linkinpark1813@";

			//String url1 = "jdbc:sqlserver://192.168.0.21;databaseName=myGIISQT";
			Connection con = DriverManager.getConnection(url1, userName, password);
			Statement s1 = con.createStatement();

			ResultSet stud = s1.executeQuery("SELECT * FROM ICSAllUsers Where UserId=" + sId);

			driver.findElement(By.name("txtuname")).sendKeys("madhu khanna");
			driver.findElement(By.name("txtPwd")).sendKeys("giis123");
			Select campus = new Select(driver.findElement(By.id("cmbBranch")));
			campus.selectByValue("Queenstown");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Admission And Enquiry']")).click();
			driver.findElement(By.xpath("//a[text()='View/Approve Withdrawal Appl.']")).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//a[@id='lnksearchtitle']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Chkstudent")).click();
			while (stud.next()) {
				String studentName = stud.getString(5) + " " + stud.getString(6);
				Select student = new Select(driver.findElement(By.id("ddlstudent")));
				Thread.sleep(1000);
				student.selectByVisibleText(studentName);
			}
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='gridstudlist']/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/a")).click();
			Thread.sleep(2000);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",
					driver.findElement(By.id("ddlReasonCatg")));
			Thread.sleep(500);
			Select reason = new Select(driver.findElement(By.id("ddlReasonCatg")));
			reason.selectByVisibleText("Health Issues");
			Thread.sleep(2000);
			driver.findElement(By.id("txtRemark_PRN")).clear();
			driver.findElement(By.id("txtRemark_PRN")).sendKeys("Approved");
			driver.findElement(By.id("but_submit")).click();
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Logout']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 3)
	public void thirdLevel() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String userName = "Nikhil";
			String password = "Linkinpark1813@";

			//String url1 = "jdbc:sqlserver://192.168.0.21;databaseName=myGIISQT";
			Connection con = DriverManager.getConnection(url1, userName, password);
			Statement s1 = con.createStatement();

			ResultSet stud = s1.executeQuery("SELECT * FROM ICSAllUsers Where UserId=" + sId);

			driver.findElement(By.name("txtuname")).sendKeys("sahadebjani");
			driver.findElement(By.name("txtPwd")).sendKeys("giis123");
			Select campus = new Select(driver.findElement(By.id("cmbBranch")));
			campus.selectByValue("Queenstown");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Admission And Enquiry']")).click();
			driver.findElement(By.xpath("//a[text()='View/Approve Withdrawal Appl.']")).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//a[@id='lnksearchtitle']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Chkstudent")).click();
			Select student = new Select(driver.findElement(By.id("ddlstudent")));
			while (stud.next()) {
				String studentName = stud.getString(5) + " " + stud.getString(6);
				Thread.sleep(1000);
				student.selectByVisibleText(studentName);
			}
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='gridstudlist']/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/a")).click();
			Thread.sleep(2000);
			/*
			 * ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);",
			 * driver.findElement(By.id("ddlReasonCatg"))); Thread.sleep(500);
			 * Select reason = new
			 * Select(driver.findElement(By.id("ddlReasonCatg")));
			 * reason.selectByVisibleText("Health Issues");
			 */
			Thread.sleep(2000);
			driver.findElement(By.id("txtRemark_ACC")).clear();
			driver.findElement(By.id("txtRemark_ACC")).sendKeys("Approved");
			driver.findElement(By.id("but_submit")).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 4)
	public void finalLevel() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String userName = "Nikhil";
			String password = "Linkinpark1813@";

			//String url1 = "jdbc:sqlserver://192.168.0.21;databaseName=myGIISQT";
			Connection con = DriverManager.getConnection(url1, userName, password);
			Statement s1 = con.createStatement();

			ResultSet stud = s1.executeQuery("SELECT * FROM ICSAllUsers Where UserId=" + sId);

			driver.findElement(By.name("txtuname")).sendKeys("Khuntia Saurabha ranjan");
			driver.findElement(By.name("txtPwd")).sendKeys("giis123");
			Select campus = new Select(driver.findElement(By.id("cmbBranch")));
			campus.selectByValue("Queenstown");
			driver.findElement(By.id("btnLogin")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[text()='Admission And Enquiry']")).click();
			driver.findElement(By.xpath("//a[text()='View/Approve Withdrawal Appl.']")).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//a[@id='lnksearchtitle']")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("Chkstudent")).click();
			Select student = new Select(driver.findElement(By.id("ddlstudent")));
			while (stud.next()) {
				String studentName = stud.getString(5) + " " + stud.getString(6);
				Thread.sleep(1000);
				student.selectByVisibleText(studentName);
			}
			driver.findElement(By.id("btnSearch")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id='gridstudlist']/tbody/tr[2]/td[2]/table/tbody/tr[1]/td/a")).click();
			Thread.sleep(2000);
			/*
			 * ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);",
			 * driver.findElement(By.id("ddlReasonCatg"))); Thread.sleep(500);
			 * Select reason = new
			 * Select(driver.findElement(By.id("ddlReasonCatg")));
			 * reason.selectByVisibleText("Health Issues");
			 */
			Thread.sleep(2000);
			driver.findElement(By.id("txtRemark_FIN")).clear();
			driver.findElement(By.id("txtRemark_FIN")).sendKeys("Approved");
			driver.findElement(By.id("but_submit")).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();
			driver.findElement(By.xpath("//a[text()='Logout']")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void closeBrowser() {

		driver.close();
	}

}

package Frameworks;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Paralleltest 
{
	@Test
	public void testlogin()
	{
		Reporter.log("thread is executed & thread id is" +Thread.currentThread().getId(), true);
	}
	
	@Test
	public void testafterlogin()
	{
		Reporter.log("thread is executed & thread id is" +Thread.currentThread().getId(), true);
	}
	
	@Test
	public void testlogout()
	{
		Reporter.log("thread is executed & thread id is" +Thread.currentThread().getId(), true);
	}

}

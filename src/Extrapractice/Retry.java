package Extrapractice;

import org.apache.xmlbeans.impl.xb.xsdschema.All.MinOccurs;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer
{
	//set counter to 0
	int minretrycount=0;
	int maxretrycount=2;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(minretrycount<=maxretrycount)
		{
			//print the test name for log
			System.out.println("following test is failin=="+ result.getName());
			
			//print the count value
			System.out.println("retrying the test count" + (minretrycount+1));
			
			//increment by 1 everytime
			minretrycount++;
			return true;
			
		}
		
			return false;
	}
	
}

package Frameworks;

public class Readexcel 
{
	public static void main(String[] args)
	{
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\nikhil\\Desktop\\TestFile.xlsx");
		
		System.out.println(excel.getdata(0, 1, 1));
		
	}
}

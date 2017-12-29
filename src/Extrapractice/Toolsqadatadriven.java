package Extrapractice;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Toolsqadatadriven {

@DataProvider(name="testdata")
public Object[][] testdatafeed() throws Exception, Exception
{

File src=new File("C://Users//nikhil//Desktop//TestFile");
Workbook wb=Workbook.getWorkbook(src);
Sheet sh1=wb.getSheet(0);
int rows=sh1.getRows();
int columns=sh1.getColumns();
System.out.println("sheet loaded sucessfully");

String inputdata[][]=new String[rows][columns];
for (int i=0;i<rows;i++)
{
 for(int j=0;j<columns;j++)
 {
	 Cell c=sh1.getCell(j,i);
	 inputdata[i][j]=c.getContents(); 
 }
}
return null;
}
}

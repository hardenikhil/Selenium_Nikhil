package Frameworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig
{
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	public ExcelDataConfig(String excelpath) 
	{
	 try {
		File src=new File(excelpath);
		
		FileInputStream fis = new FileInputStream(src);
			
		wb=new XSSFWorkbook(fis); 
			
		sh=wb.getSheetAt(0);
			
	     } 
	 catch (IOException e)
		{
			
		}
	}		
	public String getdata(int sheetnum, int row, int column)
	{
	String data=sh.getRow(row).getCell(column).getStringCellValue();
	return data;
	}
	
	public int getrowcount(int sheetindex)
	{
		int rows=wb.getSheetAt(sheetindex).getLastRowNum();
		rows=rows+1;
		return sheetindex;
		
	}
	
}

	


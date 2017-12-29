package practicedemo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ApachePOI {

	public static void main(String[] args) throws IOException 
	{	
		//give file path
		File src=new File("C:\\Users\\nikhil\\Desktop\\TestFile.xlsx");
		
		//load file
		FileInputStream fis=new FileInputStream(src);
		
		//load workbook
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sh1=wb.getSheetAt(0);
		
		System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
		System.out.println(sh1.getRow(1).getCell(0).getStringCellValue());
		System.out.println(sh1.getRow(2).getCell(0).getStringCellValue());
		System.out.println(sh1.getRow(3).getCell(0).getStringCellValue());
		//int data= (int)wb.getSheetAt(0).getRow(0).getCell(1).getNumericCellValue();
		System.out.println((int)wb.getSheetAt(0).getRow(0).getCell(1).getNumericCellValue());	
		
	}

}

package utilize;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void getDataFromExcelSheet(String SheetName, int Row, int Cell) throws EncryptedDocumentException, IOException {
		FileInputStream f = new FileInputStream("src\\test\\resources\\DataResource\\Testdata.xlsx");
		Cell s = WorkbookFactory.create(f).getSheet(SheetName).getRow(Row).getCell(Cell);
		try {
			String d = s.getStringCellValue();
			System.out.println(d);
		} 
		catch (Exception e) {
				try {
					long b = (long)s.getNumericCellValue();
					System.out.println(b);
				} catch (Exception x) {
						try {
						    Date l = s.getDateCellValue();   
						    System.out.println(l);
						}
						catch (NullPointerException y) {
							  System.out.println("Cell is blank");
						}
				}
		}
		
		f.close();
	}
	
	public static void TakeScreenShotOf(WebDriver driver, String TestID) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-mm-yyyy hh_mm_ss");
		
		LocalDateTime d = LocalDateTime.now();
	
		File dest = new File("test-output\\Failed_TestMethods_Screenshot\\" + TestID + " " + dtf.format(d) + ".jpeg");
		
		FileHandler.copy(src, dest);
		
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		getDataFromExcelSheet("Sheet1", 0, 0);
	}
	
	
	
	
}

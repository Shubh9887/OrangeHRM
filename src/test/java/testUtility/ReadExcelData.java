package testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadExcelData {

	public static String fetchExcelData(int row, int cell) throws EncryptedDocumentException, IOException {
		String data = "";
		
		String path = "src"+File.separator+"test"+File.separator+"resources"+File.separator+"Excel Test Data"+File.separator+"Amazon Test Data.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		
		Cell c = WorkbookFactory.create(file).getSheet("Amazon").getRow(row).getCell(cell);
		
		CellType type = c.getCellType();
		
		if(type==CellType.STRING) {
			data=c.getStringCellValue();
		}
		else if (type==CellType.NUMERIC) {
			double d = c.getNumericCellValue();
			
			int number = (int) d;			//Converting double value to integer by Explicit Casting to avoid .0 of double
			data=Integer.toString(number);
			
		}
		else if (type==CellType.BLANK) {
			data="";
		}
		
		return data;
		
		
	}
}

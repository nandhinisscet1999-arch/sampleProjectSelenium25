package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExeclUtility { 
	
	public String getDataFromExecl(String SheetName,int rownum, int cellnum) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
	   String data = wb.getSheet(SheetName).getRow(rownum).getCell(cellnum).toString();
		return data;
	
	}

}

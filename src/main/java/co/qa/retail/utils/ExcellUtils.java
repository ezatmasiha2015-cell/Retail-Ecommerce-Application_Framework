package co.qa.retail.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcellUtils {
	public static void getTestData(String sheetName) {
		System.out.println("Reading test data from the : " + sheetName);
		// 2; Declare one 2D object Array -- null
		Object[][] data = null;
		// 3: Establish connection with Excel file

		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/testdata/RetailUserTestData.xlsx");
			// 4: Creating workbook in the Java memory
			Workbook book = WorkbookFactory.create(ip);
			// 5: go to specific sheet
			Sheet sheet = book.getSheet(sheetName);
			// 6 Initializing the array
			data = new Object[5][];

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (EncryptedDocumentException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}

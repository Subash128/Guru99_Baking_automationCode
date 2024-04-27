package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExceldata {

	@DataProvider()
	public static String[][] getData() {
		XSSFWorkbook wb = null;
		try {

			FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "/testdata/LoginData.xlsx");
			wb = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		XSSFSheet sheet = wb.getSheetAt(0);
		int lastrow = sheet.getLastRowNum();
		short col = sheet.getRow(0).getLastCellNum();
		String[][] data = new String[lastrow][col];
		for (int i = 1; i <= lastrow; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < col; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter df = new DataFormatter();
				String value = df.formatCellValue(cell);
				data[i - 1][j] = value;
			}
		}
		try {
			wb.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return data;
	}

}

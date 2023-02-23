package mainProgram;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Formatter;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class first {

	XSSFCell uname;

	public static String[][] main() throws IOException {

		// this all interface can be accessable by apache poi only
		// XSSFWorkbook workbook
		// XSSFSheet sheet
		// XSSFRow
		// XSSFCell

		Formatter fmt = new Formatter();

		Calendar cal = Calendar.getInstance();

		fmt.format("%tc %tp", cal, cal);

		System.out.println("The Current Date and Time :" + fmt);

		FileInputStream stream = new FileInputStream("C:\\Users\\aaron\\Downloads\\practise.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(stream);

		XSSFSheet sheet = workbook.getSheet("Sheet2");

		int rows = sheet.getLastRowNum();

		int withHeaderRow = sheet.getPhysicalNumberOfRows();

		// with header

		System.out.println("with header  " + withHeaderRow);

		// sheet.getRow(1).getLastCellNum(); this will prevent from unwanted text in
		// exel

		int col = sheet.getRow(1).getLastCellNum();

		System.out.println("kundi");

		System.out.println(col);

		String[][] data = new String[rows][col];

		for (int i = 1; i <= rows; i++) {

			XSSFRow OriginalRow = sheet.getRow(i);

			for (int j = 0; j < col; j++) {

				XSSFCell OriginalCol = OriginalRow.getCell(j);

				// ,,,,,,,,,,,,,,,,,,this formatter format all cel into string including
				// numberic

				DataFormatter format = new DataFormatter();

				String value = format.formatCellValue(OriginalCol);

				data[i - 1][j] = value;

				/*
				 * System.out.println(value);
				 * 
				 * String valu=OriginalCol.getStringCellValue();
				 * 
				 * System.out.println(valu);
				 * 
				 * 
				 */

			}

		}
		System.out.println(Arrays.toString(data));

		return data;

	}

}

/*
 * int h = 1;
 * 
 * while (h > 0)
 * 
 * {
 * 
 * XSSFCell uname = OriginalRow.getCell(0);
 * 
 * XSSFCell pname = OriginalRow.getCell(1);
 * 
 * XSSFCell sname = OriginalRow.getCell(2);
 * 
 * 
 * 
 * System.out.println(uname + " " + pname + " " + sname);
 * 
 * 
 * 
 * 
 * 
 * }
 */

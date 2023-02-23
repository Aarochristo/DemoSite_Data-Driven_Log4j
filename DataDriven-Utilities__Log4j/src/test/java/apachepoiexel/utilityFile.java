package apachepoiexel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class utilityFile {

	XSSFWorkbook workbook;

	XSSFSheet sheet;

	String path = "";

	FileInputStream fromEx;

	XSSFRow rowpass;
	

	XSSFCell celldata;

	public utilityFile(String path) {

		this.path = path;
		System.out.println(path);

	}

	public int getrowcount(String sheetName) throws IOException {

		fromEx = new FileInputStream(path);

		workbook = new XSSFWorkbook(fromEx);

		sheet = workbook.getSheet(sheetName);

		int rcount = sheet.getLastRowNum();
		fromEx.close();

		return rcount;

	}

	@Test
	public int colCount(String sheetName, int row) throws IOException {

		fromEx = new FileInputStream(path);

		workbook = new XSSFWorkbook(fromEx);

		sheet = workbook.getSheet(sheetName);

		rowpass = sheet.getRow(row);

		int colum = rowpass.getLastCellNum();

		fromEx.close();
		return colum;

	}

	public String getCellData(String sheetName, int row, int colum) throws IOException {

		fromEx = new FileInputStream(path);

		workbook = new XSSFWorkbook(fromEx);

		sheet = workbook.getSheet(sheetName);

		rowpass = sheet.getRow(row);

		celldata = rowpass.getCell(colum);

		DataFormatter format = new DataFormatter();

		String cettoriginaldata = format.formatCellValue(celldata);

		fromEx.close();
		
		
		return cettoriginaldata;

	}

	
	
	
	
	

}

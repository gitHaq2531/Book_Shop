package com.client.BookShopSystem.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	private static final String path = "./Test Data/TestData.xlsx";
	public String getDataFromExcelSheet(String SheetName, int rownum, int celnum) {
		String data = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			Row row = sh.getRow(rownum);
			Cell cel = row.getCell(celnum);
			data = cel.toString();
			wb.close();
			return data;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		return data;

	}

	public int getRowCount(String SheetName) {
		int rowcount = 0;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(SheetName);
			rowcount = sh.getLastRowNum();
			wb.close();
			return rowcount;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return rowcount;

	}

	public void writeDataBackToExcel(String sheetName, int rownum, int cellnum, String value) {
	    try {
	        // Open the Excel file
	        FileInputStream fis = new FileInputStream(path);
	        Workbook wb = WorkbookFactory.create(fis);
	        fis.close(); // close input stream after reading

	        // Get or create the sheet
	        Sheet sh = wb.getSheet(sheetName);
	        if (sh == null) {
	            sh = wb.createSheet(sheetName); // assign new sheet to 'sh'
	        }

	        // Get or create the row
	        Row row = sh.getRow(rownum);
	        if (row == null) {
	            row = sh.createRow(rownum);
	        }

	        // Create the cell and set value
	        Cell cell = row.createCell(cellnum);
	        cell.setCellValue(value);

	        // Write changes back to the file
	        FileOutputStream fos = new FileOutputStream(path);
	        wb.write(fos);
	        fos.close(); // close output stream
	        wb.close();

	        System.out.println("Data written to Excel successfully: " + value);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	

	}

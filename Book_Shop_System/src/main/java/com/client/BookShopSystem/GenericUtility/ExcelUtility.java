package com.client.BookShopSystem.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelSheet(String SheetName, int rownum,int celnum ) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/appTestData.xlsx") ;
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet(SheetName);
		Row row = sh.getRow(rownum);
		 Cell cel= row.getCell(celnum);
		 String data =cel.toString();
		 wb.close();
		return data;
		
	}
	
	public int getRowCount(String SheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/appTestData.xlsx") ;
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet(SheetName);
		int rowcount = sh.getLastRowNum();
		wb.close();
		return rowcount;
		
	}
	
	public void writeDataBackToExcel(String SheetName,int rownum, int cellnum, 
			String value) throws IOException {
		FileInputStream fis = new FileInputStream("./TestData/appTestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh =wb.getSheet(SheetName);
		 Row row = sh.getRow(rownum);
		if (row == null) {  
		  row = sh.createRow(rownum);}
		Cell cell =row.createCell(cellnum);
		cell.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream("./TestData/appTestData.xlsx");
		wb.write(fos);
		wb.close();
		}
	}
		
	


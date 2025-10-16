  package com.client.BookShop_AK.Module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.ExcelUtility;

public class NewArrivalsTest extends BaseClass {
	
	@Test
	public void getAllNewArrivals() {
		List<WebElement> newArrivals = driver.findElements(By.xpath(".//div[contains(text(),'New')]/../../.."));
		
		for(WebElement book:newArrivals) {
			System.out.println(book.getText());
			
		}
		
		//write fetched book name in to excel sheet
		ExcelUtility exlib= new ExcelUtility();
		
		
		String sheetname="NewArrivals";
		exlib.writeDataBackToExcel(sheetname, 0, 0, "Serial Number");
		exlib.writeDataBackToExcel(sheetname, 0, 1, "Book Name");
		
		
		int rownum=1;
		for(WebElement book:newArrivals) {
			String bookname = book.getText();
			System.out.println("Writting Book"+ bookname);
			exlib.writeDataBackToExcel(sheetname, rownum, 0, String.valueOf(rownum));
			exlib.writeDataBackToExcel(sheetname, rownum, 1, bookname);
			rownum++;
			
		}
		System.out.println("Successfully written all New Arrival books to Excel.");
		
		
		
	}

}

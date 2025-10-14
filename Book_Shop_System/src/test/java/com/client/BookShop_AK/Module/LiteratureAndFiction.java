package com.client.BookShop_AK.Module;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.ExcelUtility;
import com.client.BookShopSystem.ObjectRepository.LiteratureFictionPage;


public class LiteratureAndFiction extends BaseClass {
	
	@Test
	public void createLiteratureAndFiction() {
		driver.findElement(By.xpath("//a[text()=' Literature & Fiction ']")).click();
		
		
		String currenturl = driver.getCurrentUrl();
		System.out.println("navigate to"+currenturl);
		
		//read filter option from ExcelUtility
		  ExcelUtility exlib= new ExcelUtility(); 
          String option = exlib.getDataFromExcelSheet("SortByoption", 4, 1);

		//apply Sortby filter
          LiteratureFictionPage lf= new LiteratureFictionPage(driver);
          
				lf.selectSortBy(option);
		
		
		//read the book name
				
				 // String bookname = exlib.getDataFromExcelSheet("AKmodule", 4,1);
		
				  //open that book catagory 
				//  EntranceExamPage eep= new EntranceExamPage(driver);
				//eep.accessSearchBaarbtn(bookname);
				
	}

}

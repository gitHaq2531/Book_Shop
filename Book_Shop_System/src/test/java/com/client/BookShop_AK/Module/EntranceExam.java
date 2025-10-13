package com.client.BookShop_AK.Module;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.ExcelUtility;
import com.client.BookShopSystem.ObjectRepository.AddToCartPage;
import com.client.BookShopSystem.ObjectRepository.BookDetailPage;
import com.client.BookShopSystem.ObjectRepository.EntranceExamPage;



public class EntranceExam extends BaseClass  {
	@Test
	public void clickOnEntreranceLink() throws InterruptedException, EncryptedDocumentException, IOException {
     System.out.println("=== Test Execution Started: Click Entrance Exam ===");
        
        // Step 1: Verify homepage is loaded
        String title = driver.getTitle();
        System.out.println("Home Page Title: " + title);
        
        // Step 2: Click on Entrance Exam module
        driver.findElement(By.xpath("//a[text()=' Entrance Exam ']")).click();
        // Step 3: Verification
		
		  String currentUrl = driver.getCurrentUrl();
		  System.out.println("Navigated to: " + currentUrl);
		  System.out.println("=== Test Execution Ended ===");
		  
		  EntranceExamPage elib= new EntranceExamPage(driver); 
		  ExcelUtility exlib= new ExcelUtility(); 
		  String bookname = exlib.getDataFromExcelSheet("AKmodule", 3,1); 
		  elib.accessSearchBaarbtn(bookname);
		 
		  Thread.sleep(4000);
		  
		  elib.clickFirstBook();
		  
		  
		  
			
			  BookDetailPage bdp=new BookDetailPage(driver); 
			  
			  String booktitle =bdp.getBookTitleEdt();
			  
			  if(booktitle.equalsIgnoreCase(bookname)) {
			  System.out.println("Book Name Matches"); } else {
			  System.out.println("Book Name Not Matches");
			 
			  }
			  
			  AddToCartPage act= new AddToCartPage();
			  act.AddToCart(driver);
			  System.out.println("Book is added to cart");
			  
			 
        
    }

		
		
}



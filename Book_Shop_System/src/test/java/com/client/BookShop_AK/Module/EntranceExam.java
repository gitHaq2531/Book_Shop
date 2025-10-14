package com.client.BookShop_AK.Module;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
		  String bookname = exlib.getDataFromExcelSheet("AKmodule", 4,1); 
		  elib.accessSearchBaarbtn(bookname);
		 
		  Thread.sleep(4000);
		  
		  elib.clickFirstBook();
		  
		  
		  
			
			  BookDetailPage bdp=new BookDetailPage(driver); 
			  
			  String booktitle =bdp.getBookTitleEdt();
			  
			  if(booktitle.equalsIgnoreCase(bookname)) {
			  System.out.println("Book Name Matches"); } else {
			  System.out.println("Book Name Not Matches");
			 
			  }
			  
			  AddToCartPage act= new AddToCartPage(driver);
			  act.clickAddToCart();
			  System.out.println("Book is added to cart");
			  
			 
			  
			  // Verify the place order page title text
			    String actualTitle = driver.findElement(By.xpath("//h2[text()='  YOUR CART ']")).getText().trim();
			    Assert.assertEquals(actualTitle, "YOUR CART", "Page title is not as expected!");

			    // Verify the Place Order button is displayed
			    WebElement placeOrderBtn = driver.findElement(By.xpath("//a[text()='Place Order']"));
			    Assert.assertTrue(placeOrderBtn.isDisplayed(), "'Place Order' button is not visible!");

			    act.clickOnPlaceOrder();
			    
			    System.out.println("Cart Page verification successful – title and button are correct.");
			
			  
			 
        
    }

		
		
}


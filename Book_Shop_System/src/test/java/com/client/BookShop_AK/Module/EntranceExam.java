package com.client.BookShop_AK.Module;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

			    System.out.println("Cart Page verification successful – title and button are correct.");
				
			    // Verify the Place Order button is displayed
			    WebElement placeOrderBtn = driver.findElement(By.xpath("//a[text()='Place Order']"));
			    Assert.assertTrue(placeOrderBtn.isDisplayed(), "'Place Order' button is not visible!");

			    act.clickOnPlaceOrder();
			    
			   
			
			 // Wait and verify success popup
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    wait.until(ExpectedConditions.alertIsPresent());
			    Alert alert = driver.switchTo().alert();
			    String alertText = alert.getText();
			    System.out.println("Order confirmation alert: " + alertText);
			    Assert.assertTrue(alertText.contains("Order SuccessFully Placed"), "Order success message mismatch!");
			    alert.accept();

			    System.out.println("order placed  successfully.");
			    
			 // verify the cart page after order placed
			    WebElement emptyCartMsg = driver.findElement(By.xpath("//span[contains(text(),'Cart Is Empty')]"));
			    Assert.assertTrue(emptyCartMsg.isDisplayed(), "Cart empty message not displayed!");

			    System.out.println("Cart is empty after order placement, and 'Do Some Shopping' button is displayed.");
			    // click on Do Some Shopping
			    act.clickOnMoreOptionbtn();
			     
			    System.out.println("Book Purchase flow completed successfully as control is on home page now ===");
    }

		
		
}


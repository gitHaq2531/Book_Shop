package com.client.BookShop_AK.Module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.ExcelUtility;
import com.client.BookShopSystem.ObjectRepository.LiteratureFictionPage;

public class AcedemicAndProfessionalTEST extends BaseClass {
	@Test
	public void executeAcedemicAndProfessional() {
		driver.findElement(By.xpath("//a[contains(text(),'Academic & Professional')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Academic and Professional STORE')]")));
		String title = header.getText().trim();
		
	  if(title.toLowerCase().contains("academic and professional")) {
		  System.out.print("navigate to:-"+title);
	  }else {
		  System.out.println("navigate in different page");
		 
	  }
	  ExcelUtility  exlib= new ExcelUtility();
	 String option = exlib.getDataFromExcelSheet("SortByoption", 2, 1);
	  
	 LiteratureFictionPage lfp= new LiteratureFictionPage(driver);
	  lfp.selectSortBy(option);
	  
	  
		
	}

}

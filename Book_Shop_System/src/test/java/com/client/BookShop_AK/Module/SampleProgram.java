package com.client.BookShop_AK.Module;

import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.ObjectRepository.EntranceExamPage;

public class SampleProgram extends BaseClass {
	@Test
	public void readBookName() {
		
		
		EntranceExamPage eep= new EntranceExamPage(driver);
	 String bookname= "kiran";
	 eep.accessSearchBaarbtn(bookname);
		eep.clickFirstBook();
	}

}

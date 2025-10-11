package com.client.BookShop_AK.Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.MasterBaseClass;

public class EntranceExamSTORE extends MasterBaseClass  {
	@Test
	public void clickOnEntreranceLink() {
		
		WebDriver d = new ChromeDriver();
		d.findElement(By.xpath(" //a[text()=' Entrance Exam ']")).click();
	}

}

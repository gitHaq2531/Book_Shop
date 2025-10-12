package com.client.BookShop_AK.Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;



public class EntranceExamSTORE extends BaseClass  {
	@Test
	public void clickOnEntreranceLink() {
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
    }

		
		
	}



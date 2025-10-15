package com.client.BookShopSystem.BaseUtility;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends MaterBaseClass {
	@BeforeMethod(alwaysRun = true)
	public void beforeMethodConfigMethod() {
		System.out.println("method level configuration start");
		String userName = futils.getDataFromPropertyFile("username");
		String password = futils.getDataFromPropertyFile("password");
		lp.login(userName, password); 
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethodConfigMethod() {try {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//span[contains(text(),'LogOut')]")
	        ));
	        logoutBtn.click();
	        System.out.println("Logged out successfully.");
	    }
	catch (Exception e) {
	        System.out.println("LogOut button not found or not clickable, skipping logout.");
	    }

	}
}


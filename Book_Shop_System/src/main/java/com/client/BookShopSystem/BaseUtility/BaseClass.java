package com.client.BookShopSystem.BaseUtility;

import java.time.Duration;

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
	public void afterMethodConfigMethod() {
        hp.logOut();
		System.out.println("user LogOut...");

	}

}

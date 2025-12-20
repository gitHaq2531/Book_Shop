package com.client.BookShopSystem.BaseUtility;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass extends MaterBaseClass {
	
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethodConfigMethod() {
	    System.out.println("method level configuration start");
	    String userName = futils.getDataFromPropertyFile("username");
	    String password = futils.getDataFromPropertyFile("password");
	    try {
	        lp.login(userName, password);
	        System.out.println("Login successful");
	    } catch(Exception e) {
	        System.out.println("Login failed: " + e.getMessage());
	   
	   
	    }
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethodConfigMethod() {
	    try {
	        hp.logOut();
	    } catch(Exception e) {
	        System.out.println("Logout failed: " + e.getMessage());
	        throw e;
	    }
	}
	
	}

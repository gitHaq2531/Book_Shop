package com.client.BookShopSystem.BaseUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject 
{
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	
	public static void setDriver(WebDriver baseDriver) {
		driver.set(baseDriver);
	}
	public static WebDriver getDriver()	{
		return driver.get();
	}
	
	public static void setTest(ExtentTest baseTest) {
		test.set(baseTest);
	}
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void removerDriver() {
		driver.remove();
	}
}

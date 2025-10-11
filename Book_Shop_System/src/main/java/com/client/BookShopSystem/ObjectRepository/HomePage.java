package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.BookShopSystem.GenericUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	WebDriverUtility webDrUtil;

	public HomePage(WebDriver driver) {
	this.driver = driver;
	webDrUtil = new WebDriverUtility(driver);
	PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//a[.=' LogOut ']")
	private WebElement logOutButton;
	public WebElement getLogOutButton() {
		return logOutButton;
	}
	
	public void logOut() {
		
		logOutButton.click();
		webDrUtil.ExplicitWaitUntilAlertIsPresent();
		webDrUtil.switcToAlertAccept();
		
	}

}

package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	WelcomePage wP ;
	public LoginPage(WebDriver driver) {
	this.driver = driver;
	wP=new WelcomePage(driver);
	PageFactory.initElements(driver, this);

	}
	
	@FindBy(id = "CustomerEmail")
	private WebElement emailTF ;
	public WebElement getEmailTF() {
		return emailTF;
	}

}

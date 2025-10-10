package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	WebDriver driver;

	public WelcomePage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);

	}
}

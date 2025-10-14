package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.client.BookShopSystem.GenericUtility.WebDriverUtility;

public class ProductListingPage {
	WebDriver driver;
	WebDriverUtility webDrUtil;

	public ProductListingPage(WebDriver driver) {
	this.driver = driver;
	webDrUtil = new WebDriverUtility(driver);
	PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//div[@class='book-block' and contains(., 'Like a Love Song')]")
	private WebElement randomeBook;
	public WebElement getRandomeBook() {
		return randomeBook;
	}
	
}

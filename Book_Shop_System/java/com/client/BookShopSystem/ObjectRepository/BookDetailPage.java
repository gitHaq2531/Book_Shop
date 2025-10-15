package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookDetailPage {
	WebDriver driver;
	public BookDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		}
	
	
@FindBy(xpath="//div[@class='col-sm-10 col-md-4 col-md-offset-1']")
private WebElement bookTitleEdt;

public String getBookTitleEdt() {
	return bookTitleEdt.getText().trim();
}



}

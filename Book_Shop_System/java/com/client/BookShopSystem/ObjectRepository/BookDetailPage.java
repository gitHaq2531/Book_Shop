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


@FindBy(xpath = "//span[contains(@style,'line-through')]")
private WebElement actualPrice;
public WebElement getActualPrice() {
	return actualPrice;
}

@FindBy(id = "buyLink")
private WebElement addToCartBtn;
public WebElement getAddToCartBtn() {
	return addToCartBtn;
}


@FindBy(xpath = "//div[@id='books']//h2")
private WebElement bookName;
public WebElement getbookName() {
	return bookName;
}


public int getPriceAfterDiscount(WebElement element) {
	String number = element.getText().substring(18, 22).trim();
	return Integer.parseInt(number);
}




}

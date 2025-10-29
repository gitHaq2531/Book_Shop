package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	WebDriver driver;
	public  AddToCartPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
		

	@FindBy (xpath="//a[@id='buyLink' and contains(text(),'ADD TO CART')]")
	private WebElement AddToCartEDT;
	
	@FindBy(xpath="//a[text()='Place Order']")
	private WebElement PalceOrderEDT;
	
	
	@FindBy(xpath="//a[text()='Do Some Shopping']")
	private WebElement MoreShoppingbtn;
	
	
	public WebElement getMoreShoppingbtn() {
		return MoreShoppingbtn;
	}

	public WebElement getPalceOrderEDT() {
		return PalceOrderEDT;
	}

	public WebElement getAddToCartEDT() {
		return AddToCartEDT;
	}
	
	public void clickAddToCart() {
		AddToCartEDT.click();
	    System.out.println("Clicked on 'Add to Cart' successfully.");
	}
	
	public void clickOnPlaceOrder() {
		PalceOrderEDT.click();
		
	}
	public void clickOnMoreOptionbtn() {
		MoreShoppingbtn.click();
	}
	
	@FindBy(xpath = "//div[@class='panel-body']")
	private WebElement orderDetail;
	public WebElement getOrderDetail() {
		return orderDetail;
	}
public String[] getProductDetailATC(WebElement element) {
String text = element.getText();
String title = text.split("Title :")[1].split("Code")[0].trim();
String quantity = text.split("Quantity :")[1].split("Price")[0].trim();
String price = text.split("Price :")[1].split("Sub")[0].trim();
String details[]= {title,quantity,price};
return details;

}

	

}

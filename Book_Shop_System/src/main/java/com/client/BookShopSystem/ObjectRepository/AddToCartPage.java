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
		
		

	

}

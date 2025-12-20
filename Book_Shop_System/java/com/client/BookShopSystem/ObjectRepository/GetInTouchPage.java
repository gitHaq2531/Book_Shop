package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetInTouchPage {
	WebDriver driver;
	public GetInTouchPage(WebDriver driver) {
		this .driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h2[contains(text(),\"Let's Get In Touch!\")]")
private WebElement GITtextEDt;
	
	public WebElement getGITtextEDt() {
		return GITtextEDt;
	}
	
	@FindBy(xpath="//p[contains(text(),'Still Confused? Give us a call or send us an email and we will get back to you as soon as possible!')]")
	private WebElement  StillConfuseEDT;
	
	public WebElement getStillConfuseEDT() {
		return StillConfuseEDT;
	}
	
	@FindBy(xpath="//p[contains(text(),'123-456-6789')]")
	private WebElement phonenumEDT;
	
	@FindBy(xpath="//p[contains(text(),'BookStore@gmail.com')]")
	private WebElement EmailEDT;
	
	public WebElement getPhonenumEDT() {
		return phonenumEDT;
	}

	public WebElement getEmailEDT() {
		return EmailEDT;
	}
	
	
	
	
	
}

package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.client.BookShopSystem.GenericUtility.WebDriverUtility;


public class SignUpPage {
	
	HomePage wp;
	WebDriver driver;
	WebDriverUtility webDrUtil;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		wp = new HomePage(driver);
		webDrUtil = new WebDriverUtility(driver);
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(name = "register_username")
	private WebElement usernameTF;
	public WebElement getUserNameTF() {
		return usernameTF;
		
	}
	
	@FindBy(name = "register_password")
	private WebElement passwordTF;
	public WebElement getPasswordTF() {
		return passwordTF;
		}
	
	@FindBy(name = "submit")
	private WebElement signUpBtn;
	public WebElement getSignUpBtn() {
		return signUpBtn;
		}//button[@value='register']
	
	


}

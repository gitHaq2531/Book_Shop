package com.client.BookShopSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.client.BookShopSystem.GenericUtility.WebDriverUtility;

public class LoginPage {

	WebDriver driver;
	WebDriverUtility webDrUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		webDrUtil = new WebDriverUtility(driver);
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "login_button")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(name = "login_username")
	private WebElement emailTF;

	public WebElement getEmailTF() {
		return emailTF;
	}

	@FindBy(name = "login_password")
	private WebElement passwordTF;

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	@FindBy(name = "submit")
	private WebElement signInButton;

	public WebElement getSignInButton() {
		return signInButton;
	}

	@FindBy(xpath = "//h4[.='Login Form']")
	private WebElement loginPageText;

	public WebElement getLoginPageText() {
		return loginPageText;
	}

	@FindBy(id = "register_button")
	private WebElement signUpButton;
	public WebElement getSignUPButton() {
		return signUpButton;
	}

	@FindBy(xpath = "//h4[.='Member Registration Form']")
	private WebElement signUPPageText;
	public WebElement getSignUPPageText() {
		return signUPPageText;
	}
	
	@FindBy(xpath = "//h4[.='Login Form']/ancestor::div[@class='modal-content']/descendant::button[.='Close']")
	private WebElement closeBtn;
	public WebElement getCloseBtn() {
		return closeBtn;
		}

	public void login(String username, String password) {

		getLoginButton().click();
		emailTF.sendKeys(username);
		passwordTF.sendKeys(password);
		signInButton.click();
		webDrUtil.switcToAlertAccept();

	}

}

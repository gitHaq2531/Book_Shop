package com.client.BookShopSystem.ObjectRepository;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.BookShopSystem.GenericUtility.WebDriverUtility;

public class HomePage {
	WebDriver driver;
	WebDriverUtility webDrUtil;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		webDrUtil = new WebDriverUtility(driver);
		PageFactory.initElements(driver, this);

	}
	/*
	 * @FindBy(xpath = "//span[contains(.,'LogOut')]") private WebElement
	 * logOutButton; public WebElement getLogOutButton() { return logOutButton; }
	 */
	
	@FindAll({
	    @FindBy(xpath = "//a[contains(text(),'LogOut')]"),
	    @FindBy(xpath = "//span[contains(.,'LogOut')]")
	})
	 private WebElement logOutButton ;

	
	
	
	@FindBy(xpath = "//a[@class='navbar-brand']")
	private WebElement bookBirdLogo;
	public WebElement getBookBirdLogo() {
		return bookBirdLogo;
	}

	@FindBy(xpath = "//img[@class='block-center img-responsive']")
	private WebElement randomeBook;
	public WebElement getRandomeBook() {
		return randomeBook;
	}

	@FindBy(xpath = "//div[@id='category']/div")
	private WebElement theBookShopText;
	public WebElement getTheBookShopText() {
		return theBookShopText;
	}

	@FindBy(xpath = "//input[contains(@placeholder,'Search')]")
	private WebElement searchBar;

	public WebElement getSearchBar() {
		return searchBar;
	}
	
	@FindBy(id = "login_button")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}

	@FindBy(xpath =  "	//h3[text()=' POPULAR AUTHORS ']")
	private WebElement popularAuthorsText;
	public WebElement getPopularAuthorText() {
		return popularAuthorsText;
	}

	@FindBy(xpath =  "//a[contains(@href, 'Durjoy')]")
	private WebElement authorDurjoy;
	public WebElement getauthorDurjoy() {
		return authorDurjoy;
	}
	
	@FindBy(xpath =  "//div[@id='category']//a[contains(text(), 'Child')]")
	private WebElement childAndTeenLink;
	public WebElement getchildAndTeenLink() {
		return childAndTeenLink;
	}
	
//	@FindBy(xpath =  "	//h3[text()=' POPULAR AUTHORS ']")
//	private WebElement bannerImageLink;
//	public WebElement getBannerImagelink() {
//		return popularAuthorsText;
//	}
//
//	@FindBy(xpath =  "//a[contains(@href, 'Durjoy')]")
//	private WebElement authorDurjoy;
//	public WebElement getauthorDurjoy() {
//		return authorDurjoy;
//	}
	
	
	
	
	
//	-------------------------------------Business Logic -----------------------------------------
	public void logOut() {
		logOutButton.click();
		webDrUtil.ExplicitWaitUntilAlertIsPresent();
		webDrUtil.switcToAlertAccept();

	}
	
	public WebElement getSideBarText(String variableText) {
	return driver.findElement(By.xpath("//div[@id='category']//a[contains(text(), '"+variableText+"')]"));
		
	}

}

package com.client.BookShopSystem.ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialMediaLinkPage {
	
	
	
	WebDriver driver;
	public SocialMediaLinkPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//img[@alt='Facebook']")
	private WebElement FaceBookEDT;
	
	
	public WebElement getFaceBookEDT() {
		return FaceBookEDT;
	}

	@FindBy(xpath="//img[@title='LinkedIn']")
	private WebElement LinkedInEDT;
	
	
	public WebElement getLinkedInEDT() {
		return LinkedInEDT;
	}
	
	@FindBy(xpath="//li-icon[@type='app-linkedin-bug-color-icon']")
	private WebElement  LinkedInLogo;
	


	public WebElement getLinkedInLogo() {
		return LinkedInLogo;
	}


	@FindBy (xpath="//img[@alt='Twitter']")
	private WebElement  TwittrEDT;
	
	@FindBy(xpath="(//a[@role='link'])[3]")
	private WebElement linkLogoEDT;

	public WebElement getTwittrEDT() {
		return TwittrEDT;
	}
	@FindBy(xpath="//span[contains(text(),'Create new account')]")
	public WebElement CreateNewAccountBTN;
	
	@FindBy(xpath="//img[@title='google+']")
	private WebElement googleLink;
	
	@FindBy(xpath=("//img[@alt='Logo' and contains(@class,'nav__logo')]"))
	public WebElement googleLogoEdt;
	
	@FindBy(xpath="//img[@title='Pinterest']")
	private WebElement pintrestbtn;
	  
	
	
	public WebElement getPintrestbtn() {
		return pintrestbtn;
	}

	@FindBy(xpath="//div[@aria-label='Close' and @role='button']")
	private WebElement fbcutbtnEDt;

	
	public WebElement getFbcutbtnEDt() {
		return fbcutbtnEDt;
	}

	public WebElement getGoogleLogoEdt() {
		return googleLogoEdt;
	}
	
	public WebElement getGoogleLink() {
		return googleLink;
	}
	public void clickOnGoogleLink() {
		googleLink.click();
		  
		
	}
	public void verifyGoogleLink() {
		
	}


	public WebElement getCreateNewAccountBTN() {
		return CreateNewAccountBTN;
	}
	public boolean  verifyGoogleLogo() {
		System.out.println("GoogleLogo is displayed");
		return googleLogoEdt.isDisplayed();
		
	}


	public WebElement getLinkLogoEDT() {
		return linkLogoEDT;
	}
	

	public void clickOnLinkedInButton() {
		LinkedInEDT.click();
		
	}
	public void clickOnTwitterbutton() {
		TwittrEDT.click();
		
	}
	public void clickOnFacebookLink() {
		FaceBookEDT.click();
	}
	public void verifyCreateAccLink() {
		CreateNewAccountBTN.isDisplayed();
		
	}
	public void clickonfbcutbutton() {
		fbcutbtnEDt.click();
	}
	public void clickOnFacebookLinkAndClosePopup() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    try {
	        // If it's in an iframe
	        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//iframe[contains(@src,'facebook')]")));
	        driver.switchTo().frame(iframe);
	    } catch (Exception e) {
	        // No iframe, continue
	    }

	    // Wait for close button
	    WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(fbcutbtnEDt));
	    closeBtn.click();

	    // Switch back to main content
	    driver.switchTo().defaultContent();
	    driver.navigate().back();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
	    driver.navigate().refresh();
	    driver.switchTo().alert().accept();
	    
	}
	
	/*
	 * public void clickOnFacebookLinkAndClosePopupAndBack() { String mainWin =
	 * driver.getWindowHandle();
	 * 
	 * // Switch to popup window for (String win : driver.getWindowHandles()) { if
	 * (!win.equals(mainWin)) { driver.switchTo().window(win); break; } }
	 * 
	 * // Wait for the cut/close button and click WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(10)); WebElement closeBtn =
	 * wait.until(ExpectedConditions.elementToBeClickable(fbcutbtnEDt));
	 * closeBtn.click();
	 * 
	 * // Close popup and switch back to main window driver.close();
	 * driver.switchTo().window(mainWin);
	 * 
	 * // Navigate back in main window driver.navigate().back(); }
	 */
}

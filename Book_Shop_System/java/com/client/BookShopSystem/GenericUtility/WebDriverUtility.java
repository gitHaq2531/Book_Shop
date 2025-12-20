 package com.client.BookShopSystem.GenericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver;
	WebDriverWait expWait ;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		 expWait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	//SWITCH TO ALLER ACTIONS
	
	public void switcToAlertAccept() {
		ExplicitWaitUntilAlertIsPresent();
		driver.switchTo().alert().accept();
	}

	public void switcToAlertCancel() {
		ExplicitWaitUntilAlertIsPresent();
		driver.switchTo().alert().dismiss();
	}

	public void switcToAlertAddMessageAccept(String message) {
		ExplicitWaitUntilAlertIsPresent();
		driver.switchTo().alert().sendKeys(message);
		driver.switchTo().alert().accept();
	}

	public String switcToAlertGetMessage() {
		ExplicitWaitUntilAlertIsPresent();
		return driver.switchTo().alert().getText();
	}

	
	//EXPLICIT WAIT
	
	  public void ExplicitWaitUntilAlertIsPresent() {
		expWait.until(ExpectedConditions.alertIsPresent());
		
	}
	public void waitUntilElementToBeClickable(WebElement element) {
		expWait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
//	Mouse action from Action class
	public void scrollToElement(WebElement element){
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
		act.scrollByAmount(0,350).perform();
		
	}	public void scrollByAmount(int a){
		Actions act = new Actions(driver);
		act.scrollByAmount(a, 0).perform();
		
	}



}

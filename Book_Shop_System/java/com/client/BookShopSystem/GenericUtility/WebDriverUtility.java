package com.client.BookShopSystem.GenericUtility;

import java.time.Duration;

import org.dataloader.Try;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver;
	WebDriverWait expWait;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
		expWait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	// SWITCH TO ALLER ACTIONS

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

	// EXPLICIT WAIT

	public void ExplicitWaitUntilAlertIsPresent() {
		expWait.until(ExpectedConditions.alertIsPresent());

	}

	public void waitUntilElementToBeClickable(WebElement element) {
		expWait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void waitUntilInvisibilityOf(WebElement element) {
		expWait.until(ExpectedConditions.invisibilityOf(element));

	}

//	Mouse action from Action class
	public void scrollToElement(WebElement element) {
		Actions act = new Actions(driver);
		act.scrollToElement(element).perform();
		act.scrollByAmount(0, 350).perform();

	}

	public void scrollByAmount(int a) {
		Actions act = new Actions(driver);
		act.scrollByAmount(a, 0).perform();

	}

	// <------------------------------------Select Class Util Start From Here
	// ----------------------------------------->
	public void selectByIndex(WebElement elemnt, int index) {

		Select select = new Select(elemnt);
		select.selectByIndex(index);

	}

	public void selectByValue(WebElement elemnt, String value) {
		Select select = new Select(elemnt);
		select.selectByValue(value);

	}

	public void selectByVisibleText(WebElement elemnt, String visibleText) {

		Select select = new Select(elemnt);
		select.selectByVisibleText(visibleText);
	}

	public int getOptionCount(WebElement elemnt) {

		Select select = new Select(elemnt);
		return select.getOptions().size();
	}

	public WebElement getFirstSelectedOption(WebElement elemnt) {

		Select select = new Select(elemnt);
		return select.getFirstSelectedOption();
	}

	public void hardWait(int x) {

		try {
			Thread.sleep(x);
		} catch (Exception e) {
			System.out.println("Retrying click...");
		}

	}

}

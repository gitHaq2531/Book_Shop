package com.client.BookShopSystem.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EntranceExamPage {
	WebDriver driver;
	public EntranceExamPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
		
	}
	
	@FindBy(xpath="//input[@name='keyword']")
	private WebElement searchBaarEDT;
	
	
	public WebElement getSearchBaarEDT() {
		return searchBaarEDT;
	}
	
	//Searchbaar and click with bookname
	public void accessSearchBaarbtn(String bookname) {
		searchBaarEDT.clear();
		searchBaarEDT.sendKeys(bookname);
		searchBaarEDT.sendKeys(Keys.ENTER);
		
		
		
	}
	// method for clicking on  first option 
	public void clickFirstBook() {
	    List<WebElement> books = driver.findElements(By.xpath("//div[@class='book-block']"));
	    if (!books.isEmpty()) {
	        books.get(0).click();
	        System.out.println("Clicked on the first book successfully.");
	    } else {
	        System.out.println("No books found on the page!");
	    }


	

}}

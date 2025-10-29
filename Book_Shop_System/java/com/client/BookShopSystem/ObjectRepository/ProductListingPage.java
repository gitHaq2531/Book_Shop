package com.client.BookShopSystem.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.client.BookShopSystem.GenericUtility.WebDriverUtility;

public class ProductListingPage {
	WebDriver driver;
	WebDriverUtility webDrUtil;

	public ProductListingPage(WebDriver driver) {
	this.driver = driver;
	webDrUtil = new WebDriverUtility(driver);
	PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='book-block' and contains(., 'Like a Love Song')]")
	private WebElement randomeBook;
	public WebElement getRandomeBook() {
		return randomeBook;
	}

	@FindBy(xpath = "//div[@class='book-block']")
	private WebElement firstBook;
	public WebElement getFirstBook() {
		return firstBook;
	}
	
	@FindBy(xpath = "//div[@class='book-block']")
	private List<WebElement> allBook;
	public List<WebElement> getAllBook() {
		return allBook;
	}
	@FindBy(xpath = "//span[@class='label label-warning']")
	private List<WebElement> allBookDiscount;
	public List<WebElement> getAllBookDiscount() {
		return allBookDiscount;
	}

	@FindBy(xpath = "//div[@id='heading']/h2")
	private WebElement heading;
	public WebElement getHeading() {
		return heading;
	}
	
	@FindBy(id = "select")
	private WebElement sortDropDown;
	public WebElement getSortDropDown() {
		return sortDropDown;
		
	}

	@FindBy(xpath = "//span[contains(@style,'line-through')]")
	private WebElement actualPrice;
	public WebElement getActualPrice() {
		return actualPrice;
	}

	public int getPriceAfterDiscount(WebElement element) {
		String number = element.getText().substring(element.getText().length() - 14, element.getText().length() - 9)
				.replaceAll("[^0-9.]", "");
		return Integer.parseInt(number);
	}

	public String getBookName2(WebElement element) {
		String text = element.getText();
		String name = "";
		for (int i = 0; i < text.length(); i++) {
			String charAt = String.valueOf(text.charAt(i));
			String number = "1234567890";
			if (!number.contains(charAt)) {
				name += charAt;
			} else {
				break;
			}

		}
		return name;
	}
	
	public String getBookName(WebElement element) {
		String name = "365 Wonders Of The World 284   450 37%";
		int totalCh = name.length(); 
		name.substring(0, totalCh-13);
		return name;
	}
public static void main(String[] args) {
	String name = "365 Wonders Of The World 284   450 37%";
	int totalCh = name.length(); 
	String str = name.substring(0, totalCh-13);
	System.out.println(str);
}}

package com.client.BookShopSystem.ObjectRepository;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.client.BookShopSystem.BaseUtility.UtilityClassObject;
import com.client.BookShopSystem.GenericUtility.WebDriverUtility;

public class AddToCartPage {
	WebDriver driver;

	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@id='buyLink' and contains(text(),'ADD TO CART')]")
	private WebElement AddToCartEDT;

	@FindBy(xpath = "//a[text()='Place Order']")
	private WebElement PalceOrderEDT;

	@FindBy(xpath = "//a[text()='Do Some Shopping']")
	private WebElement MoreShoppingbtn;

	public WebElement getMoreShoppingbtn() {
		return MoreShoppingbtn;
	}

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

	public void clickOnMoreOptionbtn() {
		MoreShoppingbtn.click();
	}

	@FindBy(xpath = "//div[@class='panel-body']")
	private WebElement orderDetail;

	public WebElement getOrderDetail() {
		return orderDetail;
	}

	@FindBy(xpath = "//a[@class='btn btn-sm']")
	private List<WebElement> removeBtn;
	@FindBy(xpath = "//a[.=' Cart ']")
	private WebElement cartBtn;
	
	public void clearCart() {
	    WebDriver localDriver = UtilityClassObject.getDriver();
	    WebDriverUtility w = new WebDriverUtility(localDriver);
	    HomePage home = new HomePage(localDriver);
	    try {
	        // temporarily reduce implicit wait to 2 seconds
	        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

	        // navigate to cart
	        w.waitUntilElementToBeClickable(home.getBookBirdLogo());
	        home.getBookBirdLogo().click();

	        w.waitUntilElementToBeClickable(cartBtn);
	        cartBtn.click();

	        List<WebElement> removeBtnList = removeBtn;

	        if (!removeBtnList.isEmpty()) {
	            for (WebElement btn : removeBtnList) {
	              
	                btn.click();
	                w.ExplicitWaitUntilAlertIsPresent();
	                w.switcToAlertAccept();
	            }
	            System.out.println("Cart cleared successfully.");
	        } else {
	            System.out.println("Cart is already empty.");
	        }
	    } catch (Exception e) {
	        System.out.println("Error while clearing cart: " + e.getMessage());
	    } finally {
	        // restore default implicit wait (e.g., 20 seconds)
	        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    }
	}


	public String[] getProductDetailATC(WebElement element) {
		String text = element.getText();
		String title = text.split("Title :")[1].split("Code")[0].trim();
		String quantity = text.split("Quantity :")[1].split("Price")[0].trim();
		String price = text.split("Price :")[1].split("Sub")[0].trim();
		String details[] = { title, quantity, price };
		return details;

	}

}

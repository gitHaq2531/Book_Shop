package com.client.BookShop_KK.Module.ChildrenAndTeens;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.client.BookShopSystem.BaseUtility.BaseClass;

public class ChildrenAndTeensTest extends BaseClass {
	
	
	@Test(groups = "integration")
	public void integrationBetweenChildAndTeensLinkAndProductListingPage() {
		hp.getchildAndTeenLink().click();
		Assert.assertEquals(plp.getHeading().isDisplayed(), true);
		 plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		String priceAfterDiscount = book.getText().substring(book.getText().length() - 13,book.getText().length() - 10);
	}

}

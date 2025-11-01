package com.client.BookShop_KK.Module.RegionalBooks;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class RegionalBooksTest extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();
	
	@Test(groups = "system")
	public void selectBookAndAddToCartAndPlaceOrderTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 5, 0);
			hp.getSideBarText(value).click();
			plp.getFirstBook().click();
			WebElement addToCartBtn = pdp.getAddToCartBtn();
			int priceAfterDiscountPDP = pdp.getPriceAfterDiscount(addToCartBtn);
			String bookNamePDP = pdp.getbookName().getText();
			WebElement quantityDropDown = pdp.getQuantityDropDown();
			String number = String.valueOf(ju.getRandomeNumber(2, 10));
			webDrUtil.selectByValue(quantityDropDown, number);
			pdp.getAddToCartBtn().click();
			String[] productDetailATC = atc.getProductDetailATC(atc.getOrderDetail());
			softAssert.assertEquals(productDetailATC[0].trim(), bookNamePDP.trim());
			softAssert.assertEquals(productDetailATC[1], number);
			softAssert.assertTrue(Integer.parseInt(productDetailATC[2]) == priceAfterDiscountPDP);
			softAssert.assertAll();
			atc.clickOnPlaceOrder();
			webDrUtil.ExplicitWaitUntilAlertIsPresent();
			webDrUtil.switcToAlertAccept();
			atc.getMoreShoppingbtn().click();
			Assert.assertTrue(hp.getBookBirdLogo().isDisplayed());
	}
}

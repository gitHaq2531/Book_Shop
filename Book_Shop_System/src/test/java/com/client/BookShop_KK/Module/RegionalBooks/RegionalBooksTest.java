package com.client.BookShop_KK.Module.RegionalBooks;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class RegionalBooksTest extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();
	@Test(groups = "integration")
	public void integrationBetweenChildAndTeensLinkAndProductListingPage() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 5, 0);
		hp.getSideBarText(value).click();
		Assert.assertEquals(plp.getHeading().isDisplayed(), true);
		 plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		int priceAfterDiscount = plp.getPriceAfterDiscount(book);
//		int priceAfterDiscount2 =Integer.parseInt( book.getText().substring(book.getText().length() - 13,book.getText().length() - 10));
		Assert.assertTrue(priceAfterDiscount>0);
		plp.getActualPrice().isDisplayed();
	}
	@Test(groups = "system")
	public void selectBookAndAddToCartTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 5, 0);
			hp.getSideBarText(value).click();
			plp.getFirstBook().click();
			WebElement addToCartBtn = pdp.getAddToCartBtn();
			int priceAfterDiscountPDP = pdp.getPriceAfterDiscount(addToCartBtn);
			String bookNamePDP = pdp.getbookName().getText();
			WebElement quantityDropDown = pdp.getQuantityDropDown();			
			int count = webDrUtil.getOptionCount(quantityDropDown);
			String number = String.valueOf(ju.getRandomeNumber(1, count));
			webDrUtil.selectByValue(quantityDropDown, number);
			pdp.getAddToCartBtn().click();
			String[] productDetailATC = atc.getProductDetailATC(atc.getOrderDetail());
			softAssert.assertEquals(productDetailATC[0].trim(), bookNamePDP.trim());
			softAssert.assertEquals(productDetailATC[1], number);
			softAssert.assertTrue(Integer.parseInt(productDetailATC[2]) == priceAfterDiscountPDP);
			softAssert.assertAll();
			atc.clearCart();
	}
	@Test(groups = "system")
	public void selectBookAndAddToCartAndPlaceOrderTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 5, 0);
			hp.getSideBarText(value).click();
			plp.getFirstBook().click();
			WebElement addToCartBtn = pdp.getAddToCartBtn();
			int priceAfterDiscountPDP = pdp.getPriceAfterDiscount(addToCartBtn);
			String bookNamePDP = pdp.getbookName().getText();
			WebElement quantityDropDown = pdp.getQuantityDropDown();
			int count = webDrUtil.getOptionCount(quantityDropDown);
			String number = String.valueOf(ju.getRandomeNumber(1, count));
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
	
	@Test(groups = "system")
	public void sortAndSelectBookAndAddToCartAndPlaceOrderTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 5, 0);
			hp.getSideBarText(value).click();
			WebElement sortDropDown = plp.getSortDropDown();
			webDrUtil.selectByVisibleText(sortDropDown, "Highest To Lowest Discount");
			int baseDiscount = 0;
			List<WebElement> allBook = plp.getAllBookDiscount();
			for (WebElement oneBookDisc : allBook) {
				int discount = Integer.parseInt(oneBookDisc.getText().trim().replace("%", ""));
				if (baseDiscount == 0)
					baseDiscount = discount;
				System.out.println("baseDiscount = " + baseDiscount + "  discount = " + discount);
				softAssert.assertTrue(discount <= baseDiscount);
				baseDiscount = discount;
			}
			plp.getFirstBook().click();
			WebElement addToCartBtn = pdp.getAddToCartBtn();
			int priceAfterDiscountPDP = pdp.getPriceAfterDiscount(addToCartBtn);
			String bookNamePDP = pdp.getbookName().getText();
			WebElement quantityDropDown = pdp.getQuantityDropDown();
			int count = webDrUtil.getOptionCount(quantityDropDown);
			String number = String.valueOf(ju.getRandomeNumber(1, count));
			webDrUtil.selectByValue(quantityDropDown, number);
			pdp.getAddToCartBtn().click();
			String[] productDetailATC = atc.getProductDetailATC(atc.getOrderDetail());
			softAssert.assertEquals(productDetailATC[0].trim(), bookNamePDP.trim());
			softAssert.assertEquals(productDetailATC[1], number);
			softAssert.assertTrue(Integer.parseInt(productDetailATC[2]) == priceAfterDiscountPDP);
			atc.clickOnPlaceOrder();
			webDrUtil.ExplicitWaitUntilAlertIsPresent();
			webDrUtil.switcToAlertAccept();
			atc.getMoreShoppingbtn().click();
			softAssert.assertTrue(hp.getBookBirdLogo().isDisplayed());
			softAssert.assertAll();
	}
}

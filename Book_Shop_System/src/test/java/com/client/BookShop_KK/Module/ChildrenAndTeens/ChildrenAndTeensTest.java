package com.client.BookShop_KK.Module.ChildrenAndTeens;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class ChildrenAndTeensTest extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();
	@Test(groups = "integration")
	public void integrationBetweenChildAndTeensLinkAndProductListingPage() {
		hp.getchildAndTeenLink().click();
		Assert.assertEquals(plp.getHeading().isDisplayed(), true);
		 plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		int priceAfterDiscount =Integer.parseInt( book.getText().substring(book.getText().length() - 13,book.getText().length() - 10));
		Assert.assertTrue(priceAfterDiscount>0);
		plp.getActualPrice().isDisplayed();
	}
	@Test(groups = "system")
	public void selectBookAndAddToCartTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 4, 0);
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
			atc.clearCart();
	}
	@Test(groups = "system")
	public void selectBookAndAddToCartAndPlaceOrderTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 4, 0);
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
			atc.clickOnPlaceOrder();
			webDrUtil.ExplicitWaitUntilAlertIsPresent();
			webDrUtil.switcToAlertAccept();
			atc.getMoreShoppingbtn().click();
			softAssert.assertTrue(hp.getBookBirdLogo().isDisplayed());
			softAssert.assertAll();
	}
	@Test(groups = "system")
	public void sortAndSelectBookAndAddToCartAndPlaceOrderTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 4, 0);
			hp.getSideBarText(value).click();
			WebElement sortDropDown = plp.getSortDropDown();
			webDrUtil.selectByVisibleText(sortDropDown, "Low To High Price ");
			int basePrice = 0;
			System.out.println("================");
			List<WebElement> allBook = plp.getAllBook();
			for (WebElement oneBook : allBook) {
				int finalPrice = plp.getPriceAfterDiscount(oneBook);
				System.out.println("BasePrice = " + basePrice + "  FinalPrice = " + finalPrice);
				softAssert.assertTrue(finalPrice >= basePrice);
				basePrice = finalPrice;
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

package com.client.BookShop_KK.Module.PopularAuthors;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class PopularAuthorsTest extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();

	@Test(groups = "Smoke")
	public void verifyPopularAuthorDisplayedTestTest() {
		Assert.assertEquals(hp.getPopularAuthorText().isDisplayed(), true);
	}

	@Test(groups = "Smoke")
	public void verifyPopularAuthorLink() {

		webDrUtil.scrollToElement(hp.getPopularAuthorText());
		hp.getauthorDurjoy().click();
		String text = plp.getHeading().getText();
		Assert.assertEquals(text.toLowerCase().contains("durjoy"), true);
	}

	@Test(groups = "Smoke")
	public void verifyBannerLinkLinkTest() {

		webDrUtil.scrollToElement(hp.getPopularAuthorText());
		hp.getauthorDurjoy().click();
		String text = plp.getHeading().getText();
		Assert.assertEquals(text.toLowerCase().contains("durjoy"), true);
	}

	@Test(groups = "system")
	public void navigateToPopularAuthorSelectBookAddToCartTest() {
		webDrUtil.scrollToElement(hp.getPopularAuthorText());
		hp.getauthorDurjoy().click();
		String text = plp.getHeading().getText();
		Assert.assertEquals(text.toLowerCase().contains("durjoy"), true);
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

	@Test(groups = "system", dataProvider = "categoryNamesData")
	public void navigateToPopularAuthorSelectBookAndPlaceOrderTestTest(String name, String storeName) {
		webDrUtil.scrollToElement(hp.getPopularAuthorText());
		hp.getAuthorName(name).click();

		String text = plp.getHeading().getText();
		softAssert.assertEquals(text.contains(storeName), true);

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
		atc.clearCart();
	}

	@Test(groups = "system")
	public void sortPriceSelectAddToCartAndPlaceOrderFromPopularAuthorTest() {
		webDrUtil.scrollToElement(hp.getPopularAuthorText());
		hp.getAuthorName("Durjoy").click();
		String text = plp.getHeading().getText();
		System.out.println(text);
		softAssert.assertEquals(text.contains("DURJOY"), true);
		System.out.println(plp.getSortDropDown().getText());
		plp.getSortDropDown().click();
		plp.getPriceHtoLOption().click();// High to Low
		int basePrice = 0;
		List<WebElement> allBook = plp.getAllBook();
		for (WebElement oneBook : allBook) {
			int nextPrice = plp.getPriceAfterDiscount(oneBook);
			if (basePrice == 0)
				basePrice = nextPrice;

			softAssert.assertTrue(nextPrice <= basePrice);
			basePrice = nextPrice;
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

	@Test(groups = "system")
	public void sortDiscountSelectAddToCartAndPlaceOrderFromPopularAuthorTest() {
		webDrUtil.scrollToElement(hp.getPopularAuthorText());
		hp.getAuthorName("Rowling").click();

		String text = plp.getHeading().getText();
		System.out.println(text);
		softAssert.assertEquals(text.contains("ROWLING"), true);
		plp.getSortDropDown().click();
		plp.getDiscountLtoHOption().click();
		int baseDiscount = 0;
		List<WebElement> allBook = plp.getAllBookDiscount();
		for (WebElement oneBookDisc : allBook) {
			int discount = Integer.parseInt(oneBookDisc.getText().trim().replace("%", ""));
			System.out.println("BasePrice = " + baseDiscount + "  FinalPrice = " + discount);
			softAssert.assertTrue(discount >= baseDiscount);
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

	@DataProvider(name = "categoryNamesData")
	public Object[][] categoryNamesData() {
		// You have data from row 4 to 8 → total 5 rows (4, 5, 6, 7)
		int startRow = 13;
		int endRow = 16;
		int totalRows = endRow - startRow + 1;
		//
		Object[][] data = new Object[totalRows][2];
		// Loop through rows and fetch data
		for (int i = 0; i < totalRows; i++) {
			String value = exlutil.getDataFromExcelSheet("Kaif Khan", startRow + i, 0);
			String value2 = exlutil.getDataFromExcelSheet("Kaif Khan", startRow + i, 1);
			data[i][1] = value2;
			data[i][0] = value;
		}
		return data;
	}

}

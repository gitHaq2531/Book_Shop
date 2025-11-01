package src.test.java.com.client.BookShop_KK.Module.BusinessAndManagement;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class BusinessAndManagement extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();
//PASS
	@Test(groups = "integration")
	public void businessAndManagementLinkAndProductListingPageTest() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
//		hp.getchildAndTeenLink().click();
//		Assert.assertEquals(text.toLowerCase(), n.toLowerCase());
		Assert.assertEquals(plp.getHeading().isDisplayed(), true);
		plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		int priceAfterDiscount = plp.getPriceAfterDiscount(book);
		Assert.assertTrue(priceAfterDiscount > 0);
		Assert.assertTrue(plp.getActualPrice().isDisplayed());
	}

//PASS
	@Test(groups = "integration")
	public void businessAndManagementLinkAndProductDetailPageTest() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
		plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		String bookNamePLP = plp.getBookName(book);
		int priceAfterDiscountPLP = plp.getPriceAfterDiscount(book);
		int actualPricePLP = Integer.parseInt(plp.getActualPrice().getText());
		plp.getFirstBook().click();
		WebElement addToCartBtn = pdp.getAddToCartBtn();
		int priceAfterDiscountPDP = pdp.getPriceAfterDiscount(addToCartBtn);
		int actualPricePDP = Integer.parseInt(pdp.getActualPrice().getText().replace("RS", ""));
		String bookNamePDP = pdp.getbookName().getText();
		softAssert.assertEquals(actualPricePLP, actualPricePDP);
		softAssert.assertEquals(priceAfterDiscountPLP, priceAfterDiscountPDP);
		softAssert.assertTrue(bookNamePDP.trim().contains(bookNamePLP.trim()));
		System.out.println(bookNamePDP.trim() + "============" + bookNamePLP.trim());
		softAssert.assertAll();
	}
//PASS
	@Test(groups = "integration")
	public void productDetailRemainConstantInCartPageTest() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
		plp.getFirstBook().isDisplayed();
		plp.getFirstBook().click();
		WebElement quantityDropDown = pdp.getQuantityDropDown();
		webDrUtil.selectByIndex(quantityDropDown, ju.getRandomeNumber(2, 10));
		String number = webDrUtil.getFirstSelectedOption(quantityDropDown).getText();
		WebElement addToCartBtn = pdp.getAddToCartBtn();
		int priceAfterDiscountPDP = pdp.getPriceAfterDiscount(addToCartBtn);
		String bookNamePDP = pdp.getbookName().getText();
		pdp.getAddToCartBtn().click();
		String[] productDetailATC = atc.getProductDetailATC(atc.getOrderDetail());
		softAssert.assertEquals(productDetailATC[0].trim(), bookNamePDP.trim());
		softAssert.assertEquals(productDetailATC[1], number);
		softAssert.assertTrue(Integer.parseInt(productDetailATC[2]) == priceAfterDiscountPDP);
		softAssert.assertAll();
	}

//PASS
	@Test(groups = "integration")
	public void userIsAbleToNavigateBackToHomePage() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
		plp.getFirstBook().isDisplayed();
		plp.getFirstBook().click();
		pdp.getAddToCartBtn().click();
		atc.clickOnPlaceOrder();
		webDrUtil.ExplicitWaitUntilAlertIsPresent();
		webDrUtil.switcToAlertAccept();
		atc.getMoreShoppingbtn().click();
		Assert.assertTrue(hp.getBookBirdLogo().isDisplayed());

	}

//PASS
	@Test(groups = "integration")
	public void verifySortLinkDisdplay() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
		Assert.assertTrue(plp.getSortDropDown().isDisplayed());

	}
//PASS
	@Test(groups = "integration")
	public void verifyPriceSortingLowToHigh() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
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
		softAssert.assertAll();

	}
//PASS
	@Test(groups = "integration")
	public void verifyPriceSortingHighToLow() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
		WebElement sortDropDown = plp.getSortDropDown();
		webDrUtil.selectByVisibleText(sortDropDown, "Highest To Lowest Price ");
		List<WebElement> allBook = plp.getAllBook();
		int basePrice = 0;
		for (WebElement oneBook : allBook) {
			int finalPrice = plp.getPriceAfterDiscount(oneBook);
			if (basePrice == 0)
				basePrice = finalPrice;

			softAssert.assertTrue(finalPrice <= basePrice);
			basePrice = finalPrice;
		}
		softAssert.assertAll();

	}
//PASS
	@Test(groups = "integration")
	public void verifyDiscountSortingLowToHigh() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
		hp.getSideBarText(value).click();
		WebElement sortDropDown = plp.getSortDropDown();
		webDrUtil.selectByVisibleText(sortDropDown, "Low To High Discount ");
		int baseDiscount = 0;
		List<WebElement> allBook = plp.getAllBookDiscount();
		for (WebElement oneBookDisc : allBook) {
			int discount = Integer.parseInt(oneBookDisc.getText().trim().replace("%", ""));
			System.out.println("BasePrice = " + baseDiscount + "  FinalPrice = " + discount);
			softAssert.assertTrue(discount >= baseDiscount);
			baseDiscount = discount;

		}
		softAssert.assertAll();

	}
//PaSS
	@Test(groups = "integration")
	public void verifyDiscountSortingHighToLow() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
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
		softAssert.assertAll();
	}
	
	@Test(groups = "system")
	public void selectBookAndAddToCartAndPlaceOrderTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 6, 0);
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

package src.test.java.com.client.BookShop_KK.Module.TopNavigationBar;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class TopNavigationBarTest extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();
	@Test(groups = "integration")
	public void searchBarAndProductListingPageTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 8, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
			plp.getFirstBook().isDisplayed();
			WebElement book = plp.getFirstBook();
			int priceAfterDiscount = plp.getPriceAfterDiscount(book);
			softAssert.assertTrue(priceAfterDiscount > 0);
			softAssert.assertTrue(plp.getActualPrice().isDisplayed());
			softAssert.assertTrue(!plp.getBookName(book).equals(""));
			softAssert.assertAll();
	}
	
	@Test(groups = "integration")
	public void searchBarAndProductDetailPageTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 9, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
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
			softAssert.assertAll();
	}
	
	@Test(groups = "integration")
	public void searchBarAndCartPageTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 10, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
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
			
	}
	
	@Test(groups = "integration")
	public void searchBarAndPlaceOrderTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 10, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
			plp.getFirstBook().isDisplayed();
			plp.getFirstBook().click();
			pdp.getAddToCartBtn().click();
			atc.clickOnPlaceOrder();
			webDrUtil.ExplicitWaitUntilAlertIsPresent();
			webDrUtil.switcToAlertAccept();
			atc.getMoreShoppingbtn().click();
			Assert.assertTrue(hp.getBookBirdLogo().isDisplayed());
			
	}
	
	@Test(groups = "integration")
	public void InvalidProductNameAndProductListingPageTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 11, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
			try {Thread.sleep(10);} catch (Exception e) {}
			 plp.getFirstBook().isDisplayed();
			System.out.println(plp.getFirstBook().getText());
			int priceAfterDiscount = plp.getPriceAfterDiscount(plp.getFirstBook());
			softAssert.assertTrue(priceAfterDiscount > 0);
			softAssert.assertTrue(plp.getActualPrice().isDisplayed());
			softAssert.assertTrue(!plp.getBookName(plp.getFirstBook()).equals(""));
			softAssert.assertAll();

	}
	
	@Test(groups = "integration")
	public void searchBarAndAddToCartTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 10, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
			plp.getFirstBook().isDisplayed();
			plp.getFirstBook().click();
			pdp.getAddToCartBtn().click();
//			atc.clickOnPlaceOrder();
//			webDrUtil.ExplicitWaitUntilAlertIsPresent();
//			webDrUtil.switcToAlertAccept();
//			atc.getMoreShoppingbtn().click();
//			Assert.assertTrue(hp.getBookBirdLogo().isDisplayed());
			
	}
}

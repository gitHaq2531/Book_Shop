package src.test.java.com.client.BookShop_KK.Module.HealthAndCooking;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;
 
public class HealthAndCooking extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();
	
	@Test(groups = "integration")
	public void healthAndCookingLinkAndProductListingPageTest() {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 7, 0);
		hp.getSideBarText(value).click();
//		hp.getchildAndTeenLink().click();
//		Assert.assertEquals(text.toLowerCase(), n.toLowerCase());
		Assert.assertEquals(plp.getHeading().isDisplayed(), true);
		plp.getFirstBook().isDisplayed();
		WebElement book = plp.getFirstBook();
		int priceAfterDiscount =plp.getPriceAfterDiscount(book);
    	Assert.assertTrue(priceAfterDiscount>0);
		plp.getActualPrice().isDisplayed();
	}
	
	@Test(groups = "integration")
	public void healthAndCookingLinkAndProductDetailPageTest() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 7, 0);
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
		softAssert.assertAll();
	}

	@Test(groups = "integration")
	public void productDetailRemainConstantInCarPageTest() {
		String value = exlutil.getDataFromExcelSheet("Kaif Khan", 7, 0);
		hp.getSideBarText(value).click();
		plp.getFirstBook().isDisplayed();
		plp.getFirstBook().click();
		WebElement addToCartBtn = pdp.getAddToCartBtn();
		int priceAfterDiscountPDP = pdp.getPriceAfterDiscount(addToCartBtn);
		String bookNamePDP = pdp.getbookName().getText();
		WebElement quantityDropDown = pdp.getQuantityDropDown();
		String number = String.valueOf(ju.getRandomeNumber(1, 4));
		webDrUtil.selectByValue(quantityDropDown, number);
		pdp.getAddToCartBtn().click();
		String[] productDetailATC = atc.getProductDetailATC(atc.getOrderDetail());
		softAssert.assertEquals(productDetailATC[0].trim(), bookNamePDP.trim());
System.out.println(productDetailATC[0].trim()+"=========="+ bookNamePDP.trim());
		softAssert.assertEquals(productDetailATC[1], number);
		softAssert.assertTrue(Integer.parseInt(productDetailATC[2]) == priceAfterDiscountPDP);
		softAssert.assertAll();

	}

	
}

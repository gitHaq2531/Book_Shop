package com.client.BookShop_KK.Module.HomePage;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.client.BookShopSystem.BaseUtility.BaseClass;

public class HomepageTest extends BaseClass {
	@Test(groups = "Smoke")
	public void verifyBookbirdLogoDisplayed() {
		Assert.assertEquals(hp.getBookBirdLogo().isEnabled(), true);
	}

	@Test(groups = "Smoke")
	public void verifyNavigationToHomePageViaLogo() {
		String expected = exlutil.getDataFromExcelSheet("Kaif Khan", 0, 1);
		boolean enabled = hp.getBookBirdLogo().isEnabled();
		Assert.assertEquals(enabled, true);
		hp.getRandomeBook().click();
		hp.getBookBirdLogo().click();
		WebElement actualText = hp.getTheBookShopText();
		Assert.assertEquals(actualText, expected, "Home page text mismatch");

	}

	@Test(groups = "Smoke")
	public void verifySerarchBaarVisiblity() {
		Assert.assertEquals(hp.getSearchBar().isDisplayed(), true);

	}

	@Test(groups = "Smoke")
	public void verifySerarchBaarWithValidBookName() {
		String expected = exlutil.getDataFromExcelSheet("Kaif Khan", 0, 2);
		Assert.assertEquals(hp.getSearchBar().isDisplayed(), true);
		hp.getSearchBar().sendKeys(expected);
		String actualText = plp.getRandomeBook().getText();
		Boolean res = actualText.toString().contains(expected.toString());
		Assert.assertEquals(res, true, "Book name text mismatch");
	}

	@Test(groups = "Smoke")
	public void veifyLoginButton() {
		hp.getLoginButton().click();
		Assert.assertEquals(lp.getLoginPageText().isDisplayed(), true);
	}
	
	@Test(groups = "Smoke")
	public void veifySignUpButton() {
		hp.getLoginButton().click();
		Assert.assertEquals(lp.getLoginPageText().isDisplayed(), true);
	}
//	@Test(groups = "Smoke")
//	public void veifyCategotNames() {
//		
//		
//	}
//	@DataProvider
//	public Object[][] categotNamesData() {
//		
//		String data[][]= {}
//		return null;
//		
//		
//	}

}

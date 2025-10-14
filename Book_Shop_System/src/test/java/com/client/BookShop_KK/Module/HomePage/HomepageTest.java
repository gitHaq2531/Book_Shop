package com.client.BookShop_KK.Module.HomePage;

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
		String expected = exlutil.getDataFromExcelSheet("Kaif Khan", 1, 0);
		boolean enabled = hp.getBookBirdLogo().isEnabled();
		Assert.assertEquals(enabled, true);
		hp.getRandomeBook().click();
		hp.getBookBirdLogo().click();
		String actualText = hp.getTheBookShopText().getText();
		Assert.assertEquals(actualText, expected, "Home page text mismatch");

	}

	@Test(groups = "Smoke")
	public void verifySerarchBaarVisiblity() {
		Assert.assertEquals(hp.getSearchBar().isDisplayed(), true);

	}

	@Test(groups = "Smoke")
	public void verifySerarchBaarWithValidBookName() {
		String expected = exlutil.getDataFromExcelSheet("Kaif Khan", 2, 0);
		Assert.assertEquals(hp.getSearchBar().isDisplayed(), true);
		hp.getSearchBar().sendKeys(expected);
		hp.getSearchBar().submit();
		 plp.getRandomeBook().isDisplayed();
	
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

package com.client.BookShop_KK.Module.HomePageModule;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

	
	@Test(groups = "Smoke" ,dataProvider = "categoryNamesData")
	public void veifyCategotNames(String text) {
		System.out.println(text);
		
	}
	@DataProvider(name = "categoryNamesData")
	public Object[][] categoryNamesData() {// You have data from row 4 to 8 → total 5 rows (4, 5, 6, 7, 8)
	    int startRow = 4;
	    int endRow = 7;
	    int totalRows = endRow - startRow + 1;
	    Object[][] data = new Object[totalRows][1];

	    // Loop through rows and fetch data
	    for (int i = 0; i < totalRows; i++) {
	        String value = exlutil.getDataFromExcelSheet("Kaif Khan", startRow + i, 0);
	        data[i][0] = value;
	    }

	    return data;
	}

}

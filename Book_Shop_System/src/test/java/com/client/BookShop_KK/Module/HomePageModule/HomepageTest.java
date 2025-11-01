package com.client.BookShop_KK.Module.HomePageModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.client.BookShopSystem.BaseUtility.BaseClass;
import com.client.BookShopSystem.GenericUtility.JavaUtility;

public class HomepageTest extends BaseClass {
	SoftAssert softAssert = new SoftAssert();
	JavaUtility ju = new JavaUtility();
	
	@Test(groups = "Smoke")
	public void verifyBookbirdLogoDisplayedTest() {
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
	public void verifySerarchBaarVisiblityTest() {
		Assert.assertEquals(hp.getSearchBar().isDisplayed(), true);

	}

	@Test(groups = "Smoke")
	public void verifySerarchBaarWithValidBookNameTest() {
		String expected = exlutil.getDataFromExcelSheet("Kaif Khan", 2, 0);
		Assert.assertEquals(hp.getSearchBar().isDisplayed(), true);
		hp.getSearchBar().sendKeys(expected);
		hp.getSearchBar().submit();
		plp.getRandomeBook().isDisplayed();
	}

	@Test(groups = "Smoke")
	public void veifyCategoryNamesTest() {
		// Loop through rows and fetch data
		for (int i = 4; i < 8; i++) {
			String name = exlutil.getDataFromExcelSheet("Kaif Khan", i, 0);
			System.out.println(name);
			String text = hp.getSideBarText(name).getText();
			Assert.assertEquals(hp.getSideBarText(text).isDisplayed(), true);
		}
	}

	@Test(groups = "Smoke", dataProvider = "categoryNamesData")

	public void veifyCategorylinkTest(String name, String n) {
		hp.getSideBarText(name).click();
		String text = plp.getHeading().getText();
		Assert.assertEquals(text.toLowerCase(), n.toLowerCase());
//		UtilityClassObject.getTest().log(Status.INFO, text+" Link is working");
	}
	

	@DataProvider(name = "categoryNamesData")
	public Object[][] categoryNamesData() {
		// You have data from row 4 to 8 → total 5 rows (4, 5, 6, 7)
	    int startRow = 4;
	    int endRow = 7;
	    int totalRows = endRow - startRow + 1;
	    Object[][] data = new Object[totalRows][2];
	    // Loop through rows and fetch data
	    for (int i = 0; i < totalRows; i++) {
	        String value = exlutil.getDataFromExcelSheet("Kaif Khan", startRow + i, 0);
	        String value2 = exlutil.getDataFromExcelSheet("Kaif Khan", startRow + i, 1);
	        data[i][1]=value2;
	        data[i][0] = value;   
	    } 
	    return data;
	    }
	
	
	
}
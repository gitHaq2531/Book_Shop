package src.test.java.com.client.BookShop_KK.Module.TopNavigationBar;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.client.BookShopSystem.BaseUtility.MaterBaseClass;

public class TopNavigationBarNegativeTest extends MaterBaseClass {
	SoftAssert softAssert = new SoftAssert();
	@Test(groups = {"integration","negative"} )
	public void navigateToProductListingWithoutLogin () {
		 String value = exlutil.getDataFromExcelSheet("Kaif Khan", 11, 0);
		 System.out.println(value);
			hp.getSearchBar().sendKeys(value);
			hp.getSearchBar().sendKeys(Keys.ENTER);
			String message = webDrUtil.switcToAlertGetMessage();
			webDrUtil.switcToAlertAccept();
			System.out.println(message);
			softAssert.assertTrue(hp.getBookBirdLogo().isDisplayed());
			softAssert.assertTrue(message.equals("Login To Continue"));
			softAssert.assertAll();
	}
}
